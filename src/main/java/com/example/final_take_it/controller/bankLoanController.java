package com.example.final_take_it.controller;

import com.example.final_take_it.model.BankLoan;
import com.example.final_take_it.repositiory.bankLoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return bankLoanrepo.findAll(Sort.by("bankLoanId").descending());
    }

    @GetMapping("getAllBankLoanByBankAndVendor")
    public List<BankLoan> getAllBankLoanByBankAndVendor(@RequestParam Long bankPhone, Long vendorPhone){
        List<BankLoan> allLoans = getAllBankLoan();
        List<BankLoan> allLoansByBank = allLoans.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        List<BankLoan> allLoansByVendor = allLoansByBank.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return allLoansByVendor;
    }

    @GetMapping("getAllBankLoanByBank")
    public List<BankLoan> getAllBankLoanByBank(@RequestParam Long bankPhone){
        List<BankLoan> allLoans = getAllBankLoan();
        List<BankLoan> allLoansByBank = allLoans.stream().filter(u -> Objects.equals(u.getBankId(), bankPhone)).collect(Collectors.toList());
        return allLoansByBank;
    }

    @GetMapping("getAllBankLoanByVendor")
    public List<BankLoan> getAllBankLoanByVendor(@RequestParam Long vendorPhone){
        List<BankLoan> allLoans = getAllBankLoan();
        List<BankLoan> allLoansByVendor = allLoans.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return allLoansByVendor;
    }
}
