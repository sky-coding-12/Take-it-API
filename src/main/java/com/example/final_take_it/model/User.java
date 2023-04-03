package com.example.final_take_it.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column()
    private String userName;
    @Column()
    private Long phoneNumber;
    @Column()
    private String email;
    @Column()
    private String password;
    @Column()
    private Long totalCredit;
    @Column()
    private Long totalDebit;
    @Column()
    private Long creditScore;

    @Column()
    private String securityPIN;

    @Column()
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSecurityPIN() {
        return securityPIN;
    }

    public void setSecurityPIN(String securityPIN) {
        this.securityPIN = securityPIN;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Long totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Long getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(Long totalDebit) {
        this.totalDebit = totalDebit;
    }

    public Long getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Long creditScore) {
        this.creditScore = creditScore;
    }
}
