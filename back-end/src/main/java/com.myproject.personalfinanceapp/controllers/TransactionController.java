package com.myproject.personalfinanceapp.controllers;

import com.myproject.personalfinanceapp.models.Transaction;
import com.myproject.personalfinanceapp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.save(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }
}

