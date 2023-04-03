package com.example.final_take_it.controller;

import com.example.final_take_it.model.BankLoan;
import com.example.final_take_it.repositiory.bankLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bankLoan")
public class bankLoanController {
    @Autowired
    private bankLoanRepo bankLoanrepo;

    @PostMapping("saveBankLoan")
    public BankLoan saveBankLoan(@RequestBody BankLoan bankLoan){
        return bankLoanrepo.save(bankLoan);
    }

    @GetMapping("getAllBankLoan")
    public List<BankLoan> getAllBankLoan(){
        return bankLoanrepo.findAll();
    }
}
