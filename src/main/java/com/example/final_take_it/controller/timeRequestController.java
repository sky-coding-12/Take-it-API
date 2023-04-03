package com.example.final_take_it.controller;

import com.example.final_take_it.model.TimeRequest;
import com.example.final_take_it.repositiory.timeRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("timeRequest")
public class timeRequestController {
    @Autowired
    private timeRequestRepo timeRequestRepo;

    @GetMapping("getAllTimeRequest")
    public List<TimeRequest> getAllTimeRequest(){
        return timeRequestRepo.findAll();
    }

    @PostMapping("saveTimeRequest")
    public TimeRequest saveTimeRequest(@RequestBody TimeRequest timeRequest){
        return timeRequestRepo.save(timeRequest);
    }
}
