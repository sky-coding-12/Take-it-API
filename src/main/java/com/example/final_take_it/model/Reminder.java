package com.example.final_take_it.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reminderId;
    //    Fk
    private Long userId;
    //    FK
    private Long vendorId;

    @JsonFormat(pattern= "MM-dd-yyyy",shape = JsonFormat.Shape.STRING)
    @Column(nullable = false)
    private String sendTime;

    public Long getReminderId() {
        return reminderId;
    }

    public void setReminderId(Long reminderId) {
        this.reminderId = reminderId;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
