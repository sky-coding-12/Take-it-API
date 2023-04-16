package com.example.final_take_it.controller;

import com.example.final_take_it.model.LoanOffer;
import com.example.final_take_it.model.LoanRequest;
import com.example.final_take_it.repositiory.loanRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("loanRequest")
public class loanRequestController {
    @Autowired
    private loanRequestRepo loanRequestRepo;


    @GetMapping("getAllNoticeRequest")
    public List<LoanRequest> getAllNoticeRequest(){
        return loanRequestRepo.findAll(Sort.by("loanRequestId").descending());
    }

    @PostMapping("saveLoanRequest")
    public LoanRequest saveLoanRequest(@RequestBody LoanRequest loanRequest){
        return loanRequestRepo.save(loanRequest);
    }

    @GetMapping("getLoanRequestByVendor")
    public List<LoanRequest> getLoanRequestByVendor(@RequestParam Long bankPhone, Long vendorPhone){
        List<LoanRequest> loanOffers = getAllNoticeRequest();
        List<LoanRequest> loanByBank = loanOffers.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        List<LoanRequest> loanByVendor = loanByBank.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return loanByVendor;
    }

    @GetMapping("getLoanRequestByBank")
    public List<LoanRequest> getLoanRequestByBank(@RequestParam Long bankPhone){
        List<LoanRequest> loanOffers = getAllNoticeRequest();
        List<LoanRequest> loanByBank = loanOffers.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        return loanByBank;
    }
}
