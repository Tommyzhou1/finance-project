package com.myproject.personalfinanceapp.controllers;

import com.myproject.personalfinanceapp.models.Transaction;
import com.myproject.personalfinanceapp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.save(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("itemId") String itemId) {
        Boolean deleted = transactionService.delete(itemId);
        logger.info("Deleting the transaction with id {}",itemId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

