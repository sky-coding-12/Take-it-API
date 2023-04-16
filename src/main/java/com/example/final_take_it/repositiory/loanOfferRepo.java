package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.LoanOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loanOfferRepo extends JpaRepository<LoanOffer, Long> {
}
