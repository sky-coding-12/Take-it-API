package com.example.final_take_it.controller;

import com.example.final_take_it.model.LoanOffer;
import com.example.final_take_it.repositiory.loanOfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanRequest")
public class loanOfferController {
    @Autowired
    private loanOfferRepo loanOfferRepo;

    @GetMapping("getAllNoticeOffer")
    public List<LoanOffer> getAllNoticeOffer(){
        return loanOfferRepo.findAll();
    }

    @PostMapping("saveLoanOffer")
    public LoanOffer saveLoanOffer(@RequestBody LoanOffer loanOffer){
        return loanOfferRepo.save(loanOffer);
    }
}
