package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


@Entity
public class LoanNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanNoticeId;
    //    FK
    private Long bankId;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    //    FK
    private Long vendorId;
    @JsonFormat(pattern = "MM-dd-yyyy", shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private String loanNoticeTime;

    public Long getLoanNoticeId() {
        return loanNoticeId;
    }

    public void setLoanNoticeId(Long loanNoticeId) {
        this.loanNoticeId = loanNoticeId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getLoanNoticeTime() {
        return loanNoticeTime;
    }

    public void setLoanNoticeTime(String loanNoticeTime) {
        this.loanNoticeTime = loanNoticeTime;
    }
}
