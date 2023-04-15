package com.example.final_take_it.controller;

import com.example.final_take_it.model.Transaction;
import com.example.final_take_it.model.User;
import com.example.final_take_it.model.Vendor;
import com.example.final_take_it.repositiory.userRepo;
import com.example.final_take_it.repositiory.vendorRepo;
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
@RequestMapping("user")
public class userController {
    @Autowired
    private userRepo userRepo;
    @Autowired
    private vendorRepo vendorRepo;
    @Autowired
    private transactionRepo transactionRepo;

    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }


    @GetMapping("getUserById/{userId}")
    public List<User> getUserById(@PathVariable("userId") Long userId){
        Optional<User> user = userRepo.findById(userId);
        return user.stream().filter(u -> Objects.equals(u.getUserId(), userId)).collect(Collectors.toList());

    }

    @PostMapping("getUserByPhone")
    public List<User> getUserByPhone(@RequestBody String phoneNumber){
        JSONObject json = new JSONObject(phoneNumber);
        String pNo = json.get("phoneNumber").toString();
        Long tmp = Long.valueOf(pNo);
        List<User> user = getAllUser();
        return user.stream().filter(u -> Objects.equals(u.getPhoneNumber(), tmp)).collect(Collectors.toList());
    }

    @GetMapping("getVendorOnUserCredit")
    public List<Vendor> getVendorOnUserCredit(@RequestParam Long phoneNumber){
        List<Transaction> list = transactionRepo.findAll();
        List<Transaction> collect = list.stream().filter(t -> Objects.equals(t.getUserId(), phoneNumber)).collect(Collectors.toList());
        List<Long> vendorId = new ArrayList<>();
        for (Transaction transaction : collect) {
            if (!vendorId.contains(transaction.getVendorId())) vendorId.add(transaction.getVendorId());
        }

        List<Vendor> ans = new ArrayList<>();
        List<Vendor> vendors = vendorRepo.findAll();
        for (Long id : vendorId) {
            for (Vendor vendor : vendors){
                if (Objects.equals(vendor.getPhoneNumber(), id)) ans.add(vendor);
            }
        }
        return ans;
    }

    @GetMapping("getAllTransactions")
    public List<Transaction> getAllTransactions(@RequestParam Long phoneNumber){
        List<Transaction> list = transactionRepo.findAll(Sort.by("transactionId").descending());
        List<Transaction> collect = list.stream().filter(t -> Objects.equals(t.getUserId(), phoneNumber)).collect(Collectors.toList());
        return collect;
    }

    @GetMapping("getParticularVendorTransactions")
    public List<Transaction> getParticularVendorTransactions(@RequestParam Long userPhone, Long vendorPhone){
        List<Transaction> list = transactionRepo.findAll(Sort.by("transactionId").descending());
        List<Transaction> collect = list.stream().filter(t -> Objects.equals(t.getUserId(), userPhone)).collect(Collectors.toList());
        List<Transaction> temp = collect.stream().filter(t -> Objects.equals(t.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return temp;
    }

    @GetMapping("getUser")
    public List<User> getUser(@RequestParam Long phoneNumber) {
        List<User> user = getAllUser();
        return user.stream().filter(u -> Objects.equals(u.getPhoneNumber(), phoneNumber)).collect(Collectors.toList());
    }

    @PostMapping("saveUser")
    public User saveUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping("updateUser")
    public User updateUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userRepo.deleteById(userId);
    }

    @DeleteMapping("deleteAllUser")
    public void deleteAllUser(){
        userRepo.deleteAll();
    }
}
