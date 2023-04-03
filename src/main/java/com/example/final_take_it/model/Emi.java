package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class Emi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emiId;
    //FK
    private Long bankLoanId;
    @Column(nullable = false)
    private Long numberOfEmi;

    @JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private String emiDueDate;
    @Column(nullable = false)
    private String emiStatus;

    public Long getEmiId() {
        return emiId;
    }

    public void setEmiId(Long emiId) {
        this.emiId = emiId;
    }

    public Long getBankLoanId() {
        return bankLoanId;
    }

    public void setBankLoanId(Long bankLoanId) {
        this.bankLoanId = bankLoanId;
    }

    public Long getNumberOfEmi() {
        return numberOfEmi;
    }

    public void setNumberOfEmi(Long numberOfEmi) {
        this.numberOfEmi = numberOfEmi;
    }

    public String getEmiDueDate() {
        return emiDueDate;
    }

    public void setEmiDueDate(String emiDueDate) {
        this.emiDueDate = emiDueDate;
    }

    public String getEmiStatus() {
        return emiStatus;
    }

    public void setEmiStatus(String emiStatus) {
        this.emiStatus = emiStatus;
    }
}
