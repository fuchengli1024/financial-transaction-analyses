//package com.codetest.fucheng.phonenumbers.controller;
//
//import com.codetest.fucheng.phonenumbers.service.PhoneNumberService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
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
// * @since : 20/09/2021, Mon
// **/
//@ContextConfiguration(classes = { PhoneNumbersController.class })
//@WebMvcTest
//public class PhoneNumberControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PhoneNumberService phoneNumberService;
//
//
//    @Test
//    public void testGetAllPhoneNumber() throws Exception {
//
//        String phoneNumber ="{ \"name\":\"reporting\",\"group\":\"batch\"}";
//
//        MvcResult result = mockMvc.perform(post("/v1/phoneNumber")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(phoneNumber)).andExpect(status().isOk())
//                .andReturn();
//
//    }
//
//
//}
//package com.codetest.fucheng.phonenumbers.controller;
//
//import com.codetest.fucheng.phonenumbers.service.PhoneNumberService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
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
// * @since : 20/09/2021, Mon
// **/
//@ContextConfiguration(classes = { PhoneNumbersController.class })
//@WebMvcTest
//public class PhoneNumberControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PhoneNumberService phoneNumberService;
//
//
//    @Test
//    public void testGetAllPhoneNumber() throws Exception {
//
//        String phoneNumber ="{ \"name\":\"reporting\",\"group\":\"batch\"}";
//
//        MvcResult result = mockMvc.perform(post("/v1/phoneNumber")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(phoneNumber)).andExpect(status().isOk())
//                .andReturn();
//
//    }
//
//
//}
package com.codetest.fucheng.transactionanalyses.controller;

import com.codetest.fucheng.transactionanalyses.service.TransactionAnalysesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Fucheng Li
 * @since : 26/01/2022, Wed
 **/


@ContextConfiguration(classes = { TransactionAnalysesController.class })
@WebMvcTest
public class TransactionAnalysesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionAnalysesService transactionAnalysesService;


    @Test
    public void transactionsAnalyses() throws Exception {

        String request ="{\n"
            + "\"accountId\":\"ACC334455\",\n"
            + "\"from\":\"20/10/2018 12:00:00\",\n"
            + "\"to\":\"20/10/2018 19:00:00\"\n"
            + "}";

        MvcResult result = mockMvc.perform(post("/v1/transactionsAnalyses")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(request)).andExpect(status().isOk())
                .andReturn();

    }


}

