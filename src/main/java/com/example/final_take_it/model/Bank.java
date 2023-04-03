package com.example.final_take_it.model;

import jakarta.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankId;
    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String bankAddress;

    @Column(nullable = false)
    private String bankBranch;

    @Column(nullable = false)
    private Long phoneNumber;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
