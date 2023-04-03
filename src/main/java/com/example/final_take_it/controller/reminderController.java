package com.example.final_take_it.controller;

import com.example.final_take_it.model.Reminder;
import com.example.final_take_it.repositiory.reminderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reminder")
public class reminderController {
    @Autowired
    private reminderRepo reminderRepo;

    @GetMapping("getAllReminder")
    public List<Reminder> getAllReminder(){
        return reminderRepo.findAll();
    }

    @PostMapping("saveReminder")
    public Reminder saveReminder(@RequestBody Reminder reminder){
        return reminderRepo.save(reminder);
    }
}
