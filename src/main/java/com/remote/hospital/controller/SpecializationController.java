package com.remote.hospital.controller;

import com.remote.hospital.entity.Speacialization;
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

    @GetMapping("/speacialization/")
    public List<Speacialization> getAllSpecialization(){
        return ss.GetAllspecialtion();
    }

    @PostMapping("/speacialization/")
    public Speacialization saveSpecialization(@RequestBody Speacialization s){
        return ss.CreateSpecialization(s);
    }




}
