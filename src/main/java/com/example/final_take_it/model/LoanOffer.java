package com.example.final_take_it.model;

import jakarta.persistence.*;

@Entity
public class LoanOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanOfferId;

    //    FK
    private Long bankId;
    //    FK
    private Long vendorId;

    @Column(nullable = false)
    private Long loanAmount;

    @Column(nullable = false)
    private double loanInterest;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long duration;

    public Long getLoanOfferId() {
        return loanOfferId;
    }

    public void setLoanOfferId(Long loanOfferId) {
        this.loanOfferId = loanOfferId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
