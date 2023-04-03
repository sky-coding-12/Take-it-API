package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.LoanNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loanNoticeRepo extends JpaRepository<LoanNotice, Long> {
}
