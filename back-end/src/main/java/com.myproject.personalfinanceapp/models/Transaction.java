package com.myproject.personalfinanceapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private UUID id = UUID.randomUUID();
    @NotEmpty(message = "The full description is required.")
    private String description;
    @NotNull(message = "The amount spent is required.")
    private BigDecimal amount;
    private Optional<CurrencyType> type;
    private LocalDate date = LocalDate.now();
    private Optional<Category> category;

    public Transaction() {
    }

    public Transaction(String description, BigDecimal amount, Optional<Category> category, Optional<CurrencyType> type) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Optional<CurrencyType> getCurrencyType() {
        return type;
    }

    public void setCurrencyType(Optional<CurrencyType> type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Optional<Category> getCategory() {
        return category;
    }

    public void setCategory(Optional<Category> category) {
        this.category = category;
    }
}
