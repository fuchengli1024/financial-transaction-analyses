package com.codetest.fucheng.transactionanalyses.service;

import com.codetest.fucheng.transactionanalyses.model.AnalysesResult;
import com.codetest.fucheng.transactionanalyses.model.Request;
import org.springframework.stereotype.Service;

/**
 * @author : Fucheng Li
 * @since : 20/01/2022, Mon
 **/

  @Service
  public interface TransactionAnalysesService {


  AnalysesResult analyses(Request request);


  }
