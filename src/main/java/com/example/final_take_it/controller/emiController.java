package com.example.final_take_it.controller;

import com.example.final_take_it.model.Emi;
import com.example.final_take_it.repositiory.emiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emi")
public class emiController {
    @Autowired
    private emiRepo emiRepo;

    @PostMapping("saveEmi")
    public Emi saveEmi(@RequestBody Emi emi){
        return emiRepo.save(emi);
    }

    @GetMapping("getEmi")
    public List<Emi> getAllEmi(){
        return emiRepo.findAll();
    }
}
