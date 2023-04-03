package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface vendorRepo extends JpaRepository<Vendor, Long> {
    @Query("select u FROM Vendor u WHERE u.phoneNumber =:phone")
    public List<Vendor> getVendorByPhone(@Param("phone") Long phone);
}
