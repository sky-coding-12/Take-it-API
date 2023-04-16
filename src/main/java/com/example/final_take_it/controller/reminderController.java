package com.example.final_take_it.controller;

import com.example.final_take_it.model.Reminder;
import com.example.final_take_it.model.TimeRequest;
import com.example.final_take_it.repositiory.reminderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reminder")
public class reminderController {
    @Autowired
    private reminderRepo reminderRepo;

    @GetMapping("getAllReminder")
    public List<Reminder> getAllReminder(){
        return reminderRepo.findAll(Sort.by("reminderId").descending());
    }

    @GetMapping("getReminderByUserId")
    public List<Reminder> getReminderByUserId(@RequestParam Long userPhone, Long vendorPhone){
        List<Reminder> reminders = getAllReminder();
        List<Reminder> filterByUserId = reminders.stream().filter(u -> Objects.equals(u.getUserId(), userPhone)).collect(Collectors.toList());
        List<Reminder> finalFilter = filterByUserId.stream().filter(u -> Objects.equals(u.getVendorId(), vendorPhone)).collect(Collectors.toList());
        return finalFilter;
    }

    @PostMapping("saveReminder")
    public Reminder saveReminder(@RequestBody Reminder reminder){
        return reminderRepo.save(reminder);
    }
}
