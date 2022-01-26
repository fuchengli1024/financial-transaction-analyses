package com.codetest.fucheng.transactionanalyses.service;

import com.codetest.fucheng.transactionanalyses.model.AnalysesResult;
import com.codetest.fucheng.transactionanalyses.model.Request;
import com.codetest.fucheng.transactionanalyses.model.Transaction;
import com.codetest.fucheng.transactionanalyses.model.Transaction.TransactionTypeEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionAnalysesServiceImpl implements TransactionAnalysesService {

  private static final Logger logger = LoggerFactory
      .getLogger(TransactionAnalysesServiceImpl.class);


  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  @Override
  public AnalysesResult analyses(Request request) {
    AnalysesResult analysesResult = new AnalysesResult();

    try {

      logger.info(sdf.parse(request.getFrom()).toString());
      logger.info(sdf.parse(request.getTo()).toString());

//      Long balance = transactionList.stream().filter(
//          transaction -> {
//            try {
//              return transaction.getFromAccountId().equalsIgnoreCase(request.getAccountId())
//                  && sdf.parse(request.getFrom()).before(sdf.parse(transaction.getCreatedAt()))
//                  && sdf.parse(request.getTo()).after(sdf.parse(transaction.getCreatedAt()));
//            } catch (ParseException e) {
//              throw new RuntimeException(e);
//            }
//          }).mapToLong(t -> t.getAmount()).sum();

      return getTransactions(request, analysesResult);

    } catch (IOException ex) {
      logger.info(ex.getLocalizedMessage());

    } catch (ParseException e) {
      logger.error(e.getLocalizedMessage());
      throw new RuntimeException(e);

    } catch (Exception ex) {
      logger.info(ex.getLocalizedMessage());
    }
    return analysesResult;

  }


  private AnalysesResult getTransactions(Request request, AnalysesResult analysesResult)
      throws Exception {
    List<Transaction> transactionsInTimeFrame = new ArrayList<>();
    List<Transaction> reversingTransactions = new ArrayList<>();
    logger.info(System.getProperty("user.dir"));
    try (BufferedReader br = new BufferedReader(
        new FileReader("application/src/main/resources/transactions.csv"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        Transaction transaction = new Transaction();
        transaction.setTransactionId(values[0].trim());
        transaction.setFromAccountId(values[1].trim());
        transaction.setToAccountId(values[2].trim());
        transaction.setCreatedAt(values[3].trim());
        transaction.setAmount(new BigDecimal(values[4].trim()));
        transaction.setTransactionType(TransactionTypeEnum.fromValue(values[5].trim()));
        if (values.length > 6) {
          transaction.setRelatedTransaction(values[6].trim());
        }

        //the account transactions in the time range
        if ((transaction.getFromAccountId().equalsIgnoreCase(request.getAccountId())
            || transaction.getToAccountId().equalsIgnoreCase(request.getAccountId()))
            && sdf.parse(request.getFrom()).before(sdf.parse(transaction.getCreatedAt()))
            && sdf.parse(request.getTo()).after(sdf.parse(transaction.getCreatedAt()))) {
          transactionsInTimeFrame.add(transaction);
        }

        //
        if (transaction.getTransactionType().toString().equalsIgnoreCase("REVERSAL")) {
          reversingTransactions.add(transaction);
        }
      }

      List<Transaction> qualifiedTransactions = transactionsInTimeFrame.stream()
          .filter(transaction -> {
                //the transaction has not reverted
                return reversingTransactions.stream().filter(
                    reversingTransaction -> reversingTransaction.getRelatedTransaction()
                        .equalsIgnoreCase(transaction.getTransactionId())).count() == 0;
              }
          ).collect(Collectors.toList());

      BigDecimal sum = BigDecimal.ZERO;

      for (Transaction transaction : qualifiedTransactions) {
        if (request.getAccountId().equalsIgnoreCase(transaction.getFromAccountId())) {
          logger.info(transaction.getAmount().negate().toString());
          sum = sum.add(transaction.getAmount().negate());
        } else {
          sum = sum.add(transaction.getAmount());
        }
      }

      analysesResult.setNumbers(qualifiedTransactions.size());
      analysesResult.setRelativeBalance(sum);

      return analysesResult;
    }
  }

}
