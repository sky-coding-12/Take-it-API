package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class BankLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankLoanId;
    //    FK
    private Long bankId;
    //    FK
    private Long vendorId;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    //    FK
    @Column(nullable = false)
    private double loanInterest;

    @Column(nullable = false)
    private Long duration;

    @Column(nullable = false)
    private Long loanAmount;

    public Long getBankLoanId() {
        return bankLoanId;
    }

    public void setBankLoanId(Long bankLoanId) {
        this.bankLoanId = bankLoanId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public double getInterestRate() {
        return loanInterest;
    }

    public void setInterestRate(double interestRate) {
        loanInterest = interestRate;
    }

}
