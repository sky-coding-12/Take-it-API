package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class BankLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankLoanId;
    //    FK
    private Long bankid;
    //    FK
    private Long vendorId;
    //    FK
    private Long emiId;
    @Column(nullable = false)
    private double InterestRate;

    @JsonFormat(pattern = "MM-dd-yyyy",shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private String dueDate;

    public Long getBankLoanId() {
        return bankLoanId;
    }

    public void setBankLoanId(Long bankLoanId) {
        this.bankLoanId = bankLoanId;
    }

    public Long getBankid() {
        return bankid;
    }

    public void setBankid(Long bankid) {
        this.bankid = bankid;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getEmiId() {
        return emiId;
    }

    public void setEmiId(Long emiId) {
        this.emiId = emiId;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
