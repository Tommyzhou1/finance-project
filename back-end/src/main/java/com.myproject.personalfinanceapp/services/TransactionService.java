package com.myproject.personalfinanceapp.services;

import com.myproject.personalfinanceapp.models.Transaction;
import com.myproject.personalfinanceapp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction update(String id, Transaction transaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            Transaction updatedTransaction = existingTransaction.get();
            updatedTransaction.setDescription(transaction.getDescription());
            updatedTransaction.setAmount(transaction.getAmount());
            updatedTransaction.setDate(transaction.getDate());
            updatedTransaction.setCategory(transaction.getCategory());
            updatedTransaction.setCurrencyType(transaction.getCurrencyType());
            return transactionRepository.save(updatedTransaction);
        } else {
            return null;
        }
    }

    public boolean delete(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            transactionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
