package com.vitu.projectcaju.controller;

import com.vitu.projectcaju.domain.Transaction;
import com.vitu.projectcaju.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> transaction(@RequestBody Transaction transaction) {
        log.info("Transaction: {}", transaction);
        transactionService.effect(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction successful");
    }
}
