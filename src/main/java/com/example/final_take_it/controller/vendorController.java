package com.example.final_take_it.controller;

import com.example.final_take_it.model.Transaction;
import com.example.final_take_it.model.User;
import com.example.final_take_it.model.Vendor;
import com.example.final_take_it.repositiory.vendorRepo;
import com.example.final_take_it.repositiory.userRepo;
import com.example.final_take_it.repositiory.transactionRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("vendor")
public class vendorController {
    @Autowired
    private vendorRepo vendorRepo;
    @Autowired
    private userRepo userRepo;
    @Autowired
    private transactionRepo transactionRepo;

    @GetMapping("getAllVendor")
    public List<Vendor> getAllVendor(){
        return vendorRepo.findAll();
    }

    @GetMapping("getVendorByPhone")
    public List<Vendor> getVendorByPhone(@RequestParam Long phoneNumber){
        List<Vendor> vendor = getAllVendor();
        return vendor.stream().filter(u -> Objects.equals(u.getPhoneNumber(), phoneNumber)).collect(Collectors.toList());
    }

    @PostMapping("getVendorByPhone")
    public List<Vendor> getVendorByPhone(@RequestBody String phoneNumber){
        JSONObject json = new JSONObject(phoneNumber);
        String pNo = json.get("phoneNumber").toString();
        Long tmp = Long.valueOf(pNo);
        List<Vendor> vendor = getAllVendor();
        return vendor.stream().filter(v -> Objects.equals(v.getPhoneNumber(), tmp)).collect(Collectors.toList());
    }

    @PostMapping("saveVendor")
    public Vendor saveVendor(@RequestBody Vendor vendor){
        return vendorRepo.save(vendor);
    }

    @PutMapping("updateVendor")
    public Vendor updateUser(@RequestBody Vendor vendor){
        return vendorRepo.save(vendor);
    }

    @DeleteMapping("deleteVendor/{vendorId}")
    public void deleteVendor(@PathVariable Long vendorId){
        Optional<Vendor> vendors = vendorRepo.findById(vendorId);
        userRepo.deleteById(vendorId);
    }

    @DeleteMapping("deleteAllVendor")
    public String deleteAllVendor(){
        vendorRepo.deleteAll();
        return "All Vendor Saaf!!";
    }

    @GetMapping("getAllTransactions")
    public List<Transaction> getAllTransactions(@RequestParam Long phoneNumber){
        List<Transaction> list = transactionRepo.findAll(Sort.by("transactionId").descending());
        List<Transaction> collect = list.stream().filter(t -> Objects.equals(t.getVendorId(), phoneNumber)).collect(Collectors.toList());
        return collect;
    }

    @GetMapping("getCustomerOnUserCredit")
    public List<User> getCustomerOnUserCredit(@RequestParam Long phoneNumber){
        List<Transaction> list = transactionRepo.findAll();
        List<Transaction> collect = list.stream().filter(t -> Objects.equals(t.getVendorId(), phoneNumber)).collect(Collectors.toList());
        List<Long> userId = new ArrayList<>();
        for (Transaction transaction : collect) {
            if (!userId.contains(transaction.getUserId())) userId.add(transaction.getUserId());
        }

        List<User> ans = new ArrayList<>();
        List<User> users = userRepo.findAll();
        for (Long id : userId) {
            for (User user : users){
                if (Objects.equals(user.getPhoneNumber(), id)) ans.add(user);
            }
        }
        return ans;
    }
}
