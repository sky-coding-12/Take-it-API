package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepo extends JpaRepository<Transaction, Long> {
}
