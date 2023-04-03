package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.BankLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bankLoanRepo extends JpaRepository<BankLoan,  Long> {
}
