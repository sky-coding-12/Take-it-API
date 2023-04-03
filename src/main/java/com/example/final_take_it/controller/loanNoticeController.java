package com.example.final_take_it.controller;

import com.example.final_take_it.model.LoanNotice;
import com.example.final_take_it.repositiory.loanNoticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanNotice")
public class loanNoticeController {
    @Autowired
    private loanNoticeRepo loanNoticeRepo;

    @GetMapping("getAllNotice")
    public List<LoanNotice> getAllNotice(){
        return loanNoticeRepo.findAll();
    }

    @PostMapping("saveLoanNotice")
    public LoanNotice saveLoanNotice(@RequestBody LoanNotice loanNotice){
        return loanNoticeRepo.save(loanNotice);
    }
}
