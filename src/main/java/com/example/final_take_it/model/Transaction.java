package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    //    FK
    private Long userId;
    //    FK
    private Long vendorId;
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String creditDebitStatus;

    public String getCreditDebitStatus() {
        return creditDebitStatus;
    }

    public void setCreditDebitStatus(String creditDebitStatus) {
        this.creditDebitStatus = creditDebitStatus;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    @JsonFormat(pattern = "mm/dd/yyyy",shape = JsonFormat.Shape.STRING)
    private String dueDate;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(nullable = false)
    @JsonFormat(pattern = "mm/dd/yyyy",shape = JsonFormat.Shape.STRING)
    private String transactionDate;
}
