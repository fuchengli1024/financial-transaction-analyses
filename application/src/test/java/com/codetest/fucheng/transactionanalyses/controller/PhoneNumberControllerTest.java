////package com.codetest.fucheng.phonenumbers.controller;
////
////import com.codetest.fucheng.phonenumbers.service.PhoneNumberService;
////import org.junit.jupiter.api.Test;
////import org.mockito.InjectMocks;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
////import org.springframework.test.context.ContextConfiguration;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.MvcResult;
////
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////
/////**
//// * @author : Fucheng Li
//// * @since : 20/09/2021, Mon
//// **/
////@ContextConfiguration(classes = { PhoneNumbersController.class })
////@WebMvcTest
////public class PhoneNumberControllerTest {
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @MockBean
////    private PhoneNumberService phoneNumberService;
////
////
////    @Test
////    public void testGetAllPhoneNumber() throws Exception {
////
////        String phoneNumber ="{ \"name\":\"reporting\",\"group\":\"batch\"}";
////
////        MvcResult result = mockMvc.perform(post("/v1/phoneNumber")
////                .contentType(MediaType.APPLICATION_JSON)
////                .accept(MediaType.APPLICATION_JSON)
////                .content(phoneNumber)).andExpect(status().isOk())
////                .andReturn();
////
////    }
////
////
////}
////package com.codetest.fucheng.phonenumbers.controller;
////
////import com.codetest.fucheng.phonenumbers.service.PhoneNumberService;
////import org.junit.jupiter.api.Test;
////import org.mockito.InjectMocks;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
////import org.springframework.test.context.ContextConfiguration;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.MvcResult;
////
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////
/////**
//// * @author : Fucheng Li
//// * @since : 20/09/2021, Mon
//// **/
////@ContextConfiguration(classes = { PhoneNumbersController.class })
////@WebMvcTest
////public class PhoneNumberControllerTest {
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @MockBean
////    private PhoneNumberService phoneNumberService;
////
////
////    @Test
////    public void testGetAllPhoneNumber() throws Exception {
////
////        String phoneNumber ="{ \"name\":\"reporting\",\"group\":\"batch\"}";
////
////        MvcResult result = mockMvc.perform(post("/v1/phoneNumber")
////                .contentType(MediaType.APPLICATION_JSON)
////                .accept(MediaType.APPLICATION_JSON)
////                .content(phoneNumber)).andExpect(status().isOk())
////                .andReturn();
////
////    }
////
////
////}
//package com.codetest.fucheng.transactionanalyses.controller;
//
//import com.codetest.fucheng.transactionanalyses.service.TransactionAnalysesService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @author : Fucheng Li
// * @since : 20/01/2022, Mon
// **/
//@ContextConfiguration(classes = { TransactionAnalysesController.class })
//@WebMvcTest
//public class PhoneNumberControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TransactionAnalysesService phoneNumberService;
//
//
//    @Test
//    public void testGetAllPhoneNumber() throws Exception {
//
//        String phoneNumber ="  {\n"
//            + "    \"id\": \"1\",\n"
//            + "    \"phoneNumber\": \"61434583679\",\n"
//            + "    \"customerId\": \"customer123\",\n"
//            + "    \"description\": \"optional description.\",\n"
//            + "    \"type\": \"fixedLine\",\n"
//            + "    \"status\": \"actived\",\n"
//            + "    \"simSerial\": \"89-302-720-40000001234-9\"\n"
//            + "  }";
//
//        MvcResult result = mockMvc.perform(post("/v1/phoneNumbers")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(phoneNumber)).andExpect(status().isOk())
//                .andReturn();
//
//    }
//
//
//}
//
