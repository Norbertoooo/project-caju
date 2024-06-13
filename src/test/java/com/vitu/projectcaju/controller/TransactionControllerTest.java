package com.vitu.projectcaju.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.projectcaju.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldUseVrWith5811Mcc() throws Exception {

        Transaction transaction = Transaction.builder()
                .mcc(5811)
                .id(12)
                .accountId(122)
                .merchant("M")
                .amount(BigDecimal.valueOf(100))
                .build();


        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(transaction)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void shouldUseVrWith5812Mcc() throws Exception {

        Transaction transaction = Transaction.builder()
                .mcc(5812)
                .id(12)
                .accountId(122)
                .merchant("M")
                .amount(BigDecimal.valueOf(100))
                .build();

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(transaction)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void shouldUseVaWith5411Mcc() throws Exception {

        Transaction transaction = Transaction.builder()
                .mcc(5411)
                .id(12)
                .accountId(122)
                .merchant("M")
                .amount(BigDecimal.valueOf(100))
                .build();

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(transaction)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void shouldUseVaWith5412Mcc() throws Exception {

        Transaction transaction = Transaction.builder()
                .mcc(5412)
                .id(12)
                .accountId(122)
                .merchant("M")
                .amount(BigDecimal.valueOf(100))
                .build();

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(transaction)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void shouldUseSlWithRandomMcc() throws Exception {

        Transaction transaction = Transaction.builder()
                .mcc(1233)
                .id(12)
                .accountId(122)
                .merchant("M")
                .amount(BigDecimal.valueOf(100))
                .build();

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(transaction)))
                .andExpect(status().isCreated())
                .andDo(print());

    }


}