package com.remote.hospital.controller;

import com.remote.hospital.entity.Specialization;
import com.remote.hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecializationController {
    @Autowired
    public SpecializationService ss;

    @GetMapping("/specialization/")
    public List<Specialization> getAllSpecialization(){
        return ss.GetAllspecialtion();
    }



    @PostMapping("/specialization/")
    public Specialization saveSpecialization(@RequestBody Specialization s){
        return ss.CreateSpecialization(s);
    }




}
