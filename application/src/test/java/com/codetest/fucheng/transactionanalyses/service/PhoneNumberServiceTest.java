//package com.codetest.fucheng.transactionanalyses.service;
//
//import com.codetest.fucheng.transactionanalyses.entity.PhoneNumberEntity;
//import com.codetest.fucheng.transactionanalyses.mapper.PhoneNumberMapper;
//import com.codetest.fucheng.transactionanalyses.model.PhoneNumber;
//import com.codetest.fucheng.transactionanalyses.model.PhoneNumber.StatusEnum;
//import com.codetest.fucheng.transactionanalyses.repository.PhoneNumberRepo;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
///**
// * @author : Fucheng Li
// * @since : 20/01/2022, Mon
// **/
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
//public class PhoneNumberServiceTest {
//
//  @TestConfiguration
//  static class ContextConfiguration {
//
//    @Bean
//    TransactionAnalysesService getPhoneNumberService() {
//      return new TransactionAnalysesService();
//    }
//
//  }
//
//
//  @Autowired
//  public TransactionAnalysesService phoneNumberService;
//
//  @MockBean
//  PhoneNumberRepo phoneNumberRepo;
//
//  @MockBean
//  PhoneNumberMapper phoneNumberMapper;
//
//
//  @Test
//  public void testGetAllPhoneNumber() throws Exception {
//    initPhoneNumberData();
//    List<PhoneNumber> phoneNumbers = phoneNumberService.getAllPhoneNumber();
//    assertEquals(1, phoneNumbers.size());
//
//  }
//
//  private void initPhoneNumberData() {
//    PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
//    phoneNumber.setId(1);
//    phoneNumber.setStatus("processing");
//    phoneNumber.setCustomerId("customer123");
//    phoneNumber.setPhoneNumber("614234908834");
//    phoneNumber.setSimSerial("sim-234234234");
//    List<PhoneNumberEntity> list = new ArrayList<>();
//    list.add(phoneNumber);
//
//    when(phoneNumberRepo.findAll()).thenReturn(list);
//  }
//
//
//}
