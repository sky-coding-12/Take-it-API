package com.example.final_take_it.controller;

import com.example.final_take_it.model.TimeRequest;
import com.example.final_take_it.model.Transaction;
import com.example.final_take_it.model.User;
import com.example.final_take_it.repositiory.timeRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("timeRequest")
public class timeRequestController {
    @Autowired
    private timeRequestRepo timeRequestRepo;

    @GetMapping("getAllTimeRequest")
    public List<TimeRequest> getAllTimeRequest(){
        return timeRequestRepo.findAll(Sort.by("timeRequestId").descending());
    }

    @GetMapping("getAllTimeRequestByUser")
    public List<TimeRequest> getAllTimeRequestByUser(@RequestParam Long userPhone, Long vendorPhone){
        List<TimeRequest> transactions = getAllTimeRequest();
        List<TimeRequest> filterByUserId = transactions.stream().filter(u -> Objects.equals(u.getUserId(), userPhone)).collect(Collectors.toList());
        return filterByUserId.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
    }

    @PostMapping("saveTimeRequest")
    public TimeRequest saveTimeRequest(@RequestBody TimeRequest timeRequest){
        return timeRequestRepo.save(timeRequest);
    }

    @PutMapping("updateTimeRequest")
    public TimeRequest updateTimeRequest(@RequestBody TimeRequest timeRequest){
        return timeRequestRepo.save(timeRequest);
    }

    @GetMapping("getTimeRequest")
    public List<TimeRequest> getTimeRequest(@RequestParam Long timeRequestId) {
        List<TimeRequest> requests = getAllTimeRequest();
        return requests.stream().filter(u -> Objects.equals(u.getTimeRequestId(), timeRequestId)).collect(Collectors.toList());
    }
}
