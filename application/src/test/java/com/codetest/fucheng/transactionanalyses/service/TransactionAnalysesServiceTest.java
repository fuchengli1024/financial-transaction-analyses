package com.codetest.fucheng.transactionanalyses.service;

import com.codetest.fucheng.transactionanalyses.model.AnalysesResult;
import com.codetest.fucheng.transactionanalyses.model.Request;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author : Fucheng Li
 * @since : 26/01/2022, Wed
 **/

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class TransactionAnalysesServiceTest {

  @TestConfiguration
  static class ContextConfiguration {

    @Bean
    TransactionAnalysesService TransactionAnalysesService() {
      return new TransactionAnalysesServiceImpl();
    }

  }

  @Autowired
  public TransactionAnalysesService transactionAnalysesService;


  @Test
  public void TestAnalyses() throws Exception {
    Request request = new Request();
    request.accountId("ACC334455");
    request.setFrom("20/10/2018 12:00:00");
    request.setTo("20/10/2018 19:00:00");
    AnalysesResult analysesResult = transactionAnalysesService.analyses(request);
    assertEquals(new BigDecimal("-25.00"), analysesResult.getRelativeBalance());
    assertEquals(1, analysesResult.getNumbers());

  }


}
