package com.project.bank.controller;

import com.project.bank.dao.Transaction;
import com.project.bank.dto.NewTransactionDTO;
import com.project.bank.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<String> newTransaction(@Valid @RequestBody NewTransactionDTO transaction) {
        transactionService.newTransaction(transaction);
        return ResponseEntity.ok("Transaction created successfully");
    }

    @GetMapping
    public List<Transaction> getTransactions(Long accountId) {
        return transactionService.getTransactions(accountId);
    }
}
