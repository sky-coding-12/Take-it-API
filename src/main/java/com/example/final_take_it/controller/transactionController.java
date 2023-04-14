package com.example.final_take_it.controller;

import com.example.final_take_it.model.Transaction;
import com.example.final_take_it.repositiory.transactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("transaction")
public class transactionController {
    @Autowired
    private transactionRepo transactionRepo;

    @GetMapping("getAllTransaction")
    public List<Transaction> getAllTransaction(){
        return transactionRepo.findAll(Sort.by("transactionId").descending());
    }

    @GetMapping("getTransaction")
    public List<Transaction> getTransaction(@RequestParam Long id){
        List<Transaction> transactions = getAllTransaction();
        return transactions.stream().filter(u -> Objects.equals(u.getTransactionId(), id)).collect(Collectors.toList());
    }

    @GetMapping("getUserCreditDebit")
    public List<Long> getUserCreditDebit(@RequestParam Long userPhone) {
        List<Transaction> transactions = getAllTransaction();
        List<Transaction> transactions1 = transactions.stream().filter(t -> Objects.equals(userPhone, t.getUserId())).toList();
        long totalCredit = 0, totalDebit = 0;
        for (Transaction transaction : transactions1) if (Objects.equals(transaction.getCreditDebitStatus(), "credit")) totalCredit += transaction.getAmount();
        for (Transaction transaction : transactions1) if (Objects.equals(transaction.getCreditDebitStatus(), "debit")) totalDebit += transaction.getAmount();
        List<Long> ans = new ArrayList<>();
        ans.add(totalCredit);
        ans.add(totalDebit);
        return ans;
    }

    @GetMapping("getUserCreditDebitDemo")
    public List<Long> getUserCreditDebitDemo(@RequestParam Long userPhone, Long vendorPhone) {
        List<Transaction> transactions = getAllTransaction();
        List<Transaction> transactions1 = transactions.stream().filter(t -> Objects.equals(userPhone, t.getUserId())).collect(Collectors.toList());
        List<Transaction> transactions2 = transactions.stream().filter(t -> Objects.equals(vendorPhone, t.getVendorId())).collect(Collectors.toList());
        long totalCredit = 0, totalDebit = 0;
        for (Transaction transaction : transactions2) if (Objects.equals(transaction.getCreditDebitStatus(), "credit")) totalCredit += transaction.getAmount();
        for (Transaction transaction : transactions2) if (Objects.equals(transaction.getCreditDebitStatus(), "debit")) totalDebit += transaction.getAmount();
        List<Long> ans = new ArrayList<>();
        ans.add(totalCredit);
        ans.add(totalDebit);
        return ans;
    }

    @PostMapping("saveTransaction")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionRepo.save(transaction);
    }

    @PutMapping("updateTransaction")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionRepo.save(transaction);
    }
}
