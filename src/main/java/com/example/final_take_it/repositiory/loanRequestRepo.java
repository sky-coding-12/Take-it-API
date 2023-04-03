package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loanRequestRepo extends JpaRepository<LoanRequest, Long> {
}
