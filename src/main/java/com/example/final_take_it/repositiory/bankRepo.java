package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface bankRepo extends JpaRepository<Bank, Long> {
    @Query("select u FROM Bank u WHERE u.phoneNumber =:phone")
    public List<Bank> getBankByPhone(@Param("phone") Long phone);
}
