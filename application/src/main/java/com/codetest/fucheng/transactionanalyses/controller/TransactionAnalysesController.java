package com.codetest.fucheng.transactionanalyses.controller;


import com.codetest.fucheng.transactionanalyses.api.TransactionsAnalysesApi;
import com.codetest.fucheng.transactionanalyses.model.AnalysesResult;
import com.codetest.fucheng.transactionanalyses.model.Request;
import com.codetest.fucheng.transactionanalyses.service.TransactionAnalysesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Fucheng Li
 * @since : 26/01/2022, Web
 **/

@Validated
@RequestMapping("v1/transactionsAnalyses")
@Api(tags = {"transactionsAnalyses"})
@Controller
public class TransactionAnalysesController implements TransactionsAnalysesApi {

  @Autowired

  TransactionAnalysesService transactionAnalysesService;

  private static final Logger logger = LoggerFactory.getLogger(TransactionAnalysesController.class);

  @PostMapping
  public ResponseEntity<AnalysesResult> transactionsAnalyses(@ApiParam(value = ""  )  @Valid @RequestBody Request request) {

    return new ResponseEntity<>(transactionAnalysesService.analyses(request),HttpStatus.OK);
  }

}
