package com.codetest.fucheng.transactionanalyses.service;

import com.codetest.fucheng.transactionanalyses.model.AnalysesResult;
import com.codetest.fucheng.transactionanalyses.model.Request;
import com.codetest.fucheng.transactionanalyses.model.Transaction;
import com.codetest.fucheng.transactionanalyses.model.Transaction.TransactionTypeEnum;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author : Fucheng Li
 * @since : 26/01/2022, Wed
 **/


@Service
public class TransactionAnalysesServiceImpl implements TransactionAnalysesService {

  private static final Logger logger = LoggerFactory
      .getLogger(TransactionAnalysesServiceImpl.class);

  public static final String CSV_PATH = "transactions.csv";
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  /**
   * @param request
   * @return
   */

  @Override
  public AnalysesResult analyses(Request request) {
    AnalysesResult analysesResult = new AnalysesResult();
    try {

      List<Transaction> transactionsInTimeFrame = new ArrayList<>();
      List<Transaction> reversingTransactions = new ArrayList<>();

      readTransactionsFromCSV(request, transactionsInTimeFrame, reversingTransactions);

      //get the transactions in the time range and hasn't reversing transaction
      List<Transaction> qualifiedTransactions = transactionsInTimeFrame.stream()
          .filter(transaction -> {
                //the transaction has not reverted
                return reversingTransactions.stream().filter(
                    reversingTransaction -> reversingTransaction.getRelatedTransaction()
                        .equalsIgnoreCase(transaction.getTransactionId())).count() == 0;
              }
          ).collect(Collectors.toList());

      //sum up the balance according to the from/to
      BigDecimal sum = BigDecimal.ZERO;
      for (Transaction transaction : qualifiedTransactions) {
        if (request.getAccountId().equalsIgnoreCase(transaction.getFromAccountId())) {
          sum = sum.add(transaction.getAmount().negate());
        } else {
          sum = sum.add(transaction.getAmount());
        }
      }

      analysesResult.setNumbers(qualifiedTransactions.size());
      analysesResult.setRelativeBalance(sum);

      return analysesResult;
    } catch (IOException ex) {
      logger.error(ex.getLocalizedMessage());
      throw new RuntimeException(ex);
    } catch (URISyntaxException ex) {
      logger.error(ex.getLocalizedMessage());
      throw new RuntimeException(ex);
    } catch (ParseException ex) {
      logger.error(ex.getLocalizedMessage());
      throw new RuntimeException(ex);
    } catch (Exception ex) {
      logger.error(ex.getLocalizedMessage());
      throw new RuntimeException(ex);
    }

  }

  /**
   * @param request
   * @param transactionsInTimeFrame
   * @param reversingTransactions
   * @throws IOException
   * @throws CsvValidationException
   * @throws ParseException
   * @throws URISyntaxException
   */
  private void readTransactionsFromCSV(Request request,
      List<Transaction> transactionsInTimeFrame, List<Transaction> reversingTransactions)
      throws IOException, CsvValidationException, ParseException, URISyntaxException {

    URI uri = ClassLoader.getSystemResource(CSV_PATH).toURI();
    Reader reader = Files.newBufferedReader(Paths.get(uri));

    CSVParser parser = new CSVParserBuilder()
        .withSeparator(',')
        .withIgnoreQuotations(true)
        .build();

    CSVReader csvReader = new CSVReaderBuilder(reader)
        .withSkipLines(1)
        .withCSVParser(parser)
        .build();

    String[] line;
    while ((line = csvReader.readNext()) != null) {
      Transaction transaction = new Transaction();
      transaction.setTransactionId(line[0].trim());
      transaction.setFromAccountId(line[1].trim());
      transaction.setToAccountId(line[2].trim());
      transaction.setCreatedAt(line[3].trim());
      transaction.setAmount(new BigDecimal(line[4].trim()));
      transaction.setTransactionType(TransactionTypeEnum.fromValue(line[5].trim()));
      if (line.length > 6) {
        transaction.setRelatedTransaction(line[6].trim());
      }
      //the payments of the account in the time range
      if ((transaction.getFromAccountId().equalsIgnoreCase(request.getAccountId())
          || transaction.getToAccountId().equalsIgnoreCase(request.getAccountId()))
          && sdf.parse(request.getFrom()).before(sdf.parse(transaction.getCreatedAt()))
          && sdf.parse(request.getTo()).after(sdf.parse(transaction.getCreatedAt()))
          && transaction.getTransactionType().toString().equalsIgnoreCase("PAYMENT")) {

        transactionsInTimeFrame.add(transaction);
      }
      //get all reversingTransactions
      if (transaction.getTransactionType().toString().equalsIgnoreCase("REVERSAL")) {
        reversingTransactions.add(transaction);
      }
    }

    reader.close();
    csvReader.close();
  }

}
