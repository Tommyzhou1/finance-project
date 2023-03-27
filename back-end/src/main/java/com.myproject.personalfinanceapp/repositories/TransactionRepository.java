package com.myproject.personalfinanceapp.repositories;

import com.myproject.personalfinanceapp.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}