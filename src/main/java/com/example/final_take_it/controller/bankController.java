package com.example.final_take_it.controller;

import com.example.final_take_it.model.Bank;
import com.example.final_take_it.repositiory.bankRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bank")
public class bankController {
    @Autowired
    private bankRepo bankRepo;

    @PostMapping("saveBank")
    public Bank saveBank(@RequestBody Bank bank){
        return bankRepo.save(bank);
    }

    @PutMapping("updateBank")
    public Bank updateBank(@RequestBody Bank bank){
        return bankRepo.save(bank);
    }

    @GetMapping("getBank")
    public List<Bank> getAllBank(){
        return bankRepo.findAll();
    }

    @PostMapping("getBankByPhone")
    public List<Bank> getBankByPhone(@RequestBody String phoneNumber){
        JSONObject json = new JSONObject(phoneNumber);
        String pNo = json.get("phoneNumber").toString();
        Long tmp = Long.valueOf(pNo);
        List<Bank> bank = getAllBank();
        return bank.stream().filter(b -> Objects.equals(b.getPhoneNumber(), tmp)).collect(Collectors.toList());
    }

    @GetMapping("getBankByPhone")
    public List<Bank> getVendorByPhone(@RequestParam Long phoneNumber){
        List<Bank> bank = getAllBank();
        return bank.stream().filter(u -> Objects.equals(u.getPhoneNumber(), phoneNumber)).collect(Collectors.toList());
    }
}
