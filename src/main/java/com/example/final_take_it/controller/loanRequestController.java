package com.example.final_take_it.controller;

import com.example.final_take_it.model.LoanRequest;
import com.example.final_take_it.repositiory.loanRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanRequest")
public class loanRequestController {
    @Autowired
    private loanRequestRepo loanRequestRepo;


    @GetMapping("getAllNoticeRequest")
    public List<LoanRequest> getAllNoticeRequest(){
        return loanRequestRepo.findAll();
    }

    @PostMapping("saveLoanRequest")
    public LoanRequest saveLoanRequest(@RequestBody LoanRequest loanRequest){
        return loanRequestRepo.save(loanRequest);
    }
}
