package com.remote.hospital.controller;

import com.remote.hospital.entity.Hospital;
import com.remote.hospital.entity.User;
import com.remote.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HospitalController {


    @Autowired
   private HospitalService hospitalService;


    @PostMapping("/hospital")
   public  String saveHospital(@RequestBody  Hospital hospital) {
       try
       {
          return hospitalService.saveHospital(hospital);

       }
       catch (Exception e)
       {
           return "error";
       }
   }

   @PostMapping("/hospital/accept/{id}")
   public String acceptHospital(@PathVariable String id)
   {
       return hospitalService.acceptPendingHospital(Long.parseLong(id));

   }


    @PostMapping("/hospital/disable/{id}")
    public String disableHospital(@PathVariable String id)
    {
        return hospitalService.disablePendingHospital(Long.parseLong(id));

    }



    @GetMapping("/hospital")
    public List<Hospital> findAllHospital(){
         return hospitalService.findAllHospital();
    }
    @PostMapping("/hospitallogin")
    public String Login(@RequestBody Hospital hospital) {
        return hospitalService.Login(hospital.getEmail(), hospital.getPassword());
    }


    @GetMapping("/inactive/hospitals")
    public List<Hospital> findInActiveHospitals(){
        return hospitalService.getInActiveHospitalAdmin();
    }

}
