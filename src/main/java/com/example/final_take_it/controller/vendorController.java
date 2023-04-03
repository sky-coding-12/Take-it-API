package com.example.final_take_it.controller;

import com.example.final_take_it.model.Vendor;
import com.example.final_take_it.repositiory.vendorRepo;
import com.example.final_take_it.repositiory.userRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
