package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class TimeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timeRequestId;
    //    FK
    private Long userId;
    //    FK
    private Long vendorId;

    private Long transactionId;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(nullable = false)
    @JsonFormat(pattern = "mm/dd/yyyy",shape = JsonFormat.Shape.STRING)
    private String newDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "mm/dd/yyyy",shape = JsonFormat.Shape.STRING)
    private String dueDate;

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public Long getTimeRequestId() {
        return timeRequestId;
    }

    public void setTimeRequestId(Long timeRequestId) {
        this.timeRequestId = timeRequestId;
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
}
