package com.example.final_take_it.model;

import jakarta.persistence.*;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendorId;
    @Column(nullable = false)
    private String shopName;
    @Column(nullable = false)
    private String vendorName;
    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private  Long totalDebit;
    @Column(nullable = false)
    private Long totalLoanAmount;

    @Column(nullable = false)
    private String image;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(Long totalDebit) {
        this.totalDebit = totalDebit;
    }

    public Long getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(Long totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
