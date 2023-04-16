package com.example.final_take_it.controller;

import com.example.final_take_it.model.LoanOffer;
import com.example.final_take_it.repositiory.loanOfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("loanOffer")
public class loanOfferController {
    @Autowired
    private loanOfferRepo loanOfferRepo;

    @GetMapping("getAllNoticeOffer")
    public List<LoanOffer> getAllNoticeOffer(){
        return loanOfferRepo.findAll(Sort.by("loanOfferId").descending());
    }

    @PostMapping("saveLoanOffer")
    public LoanOffer saveLoanOffer(@RequestBody LoanOffer loanOffer){
        return loanOfferRepo.save(loanOffer);
    }

    @GetMapping("getLoanOfferByVendor")
    public List<LoanOffer> getLoanOfferByVendor(@RequestParam Long bankPhone, Long vendorPhone){
        List<LoanOffer> loanOffers = getAllNoticeOffer();
        List<LoanOffer> loanByBank = loanOffers.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        List<LoanOffer> loanByVendor = loanByBank.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return loanByVendor;
    }

    @GetMapping("getLoanOfferByBank")
    public List<LoanOffer> getLoanOfferByBank(@RequestParam Long bankPhone){
        List<LoanOffer> loanOffers = getAllNoticeOffer();
        List<LoanOffer> loanByBank = loanOffers.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        return loanByBank;
    }
}
