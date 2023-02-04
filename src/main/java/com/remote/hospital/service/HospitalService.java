package com.remote.hospital.service;

import com.remote.hospital.entity.Hospital;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    public Hospital getHospitalByEmail(String email) {
        return hospitalRepository.findByEmail(email);
    }


    public  String acceptPendingHospital(Long Id)
{
   Hospital hospital = hospitalRepository.findById(Id).orElse(null);
    hospital.setActive(true);
    hospitalRepository.save(hospital);
    return "success";
}

    public  String disablePendingHospital(Long Id)
    {
        Hospital hospital = hospitalRepository.findById(Id).orElse(null);
        hospital.setActive(false);
        hospitalRepository.save(hospital);
        return "success";
    }


    public String saveHospital(Hospital  hospital) {
        try
        {
            hospital.setCreatedOn(new java.util.Date());
            hospital.setActive( false);
            hospitalRepository.save(hospital);
            return "success";
        }
        catch (Exception e)
        {
            return "error";
        }
    }



    public List<Hospital> getInActiveHospitalAdmin() {


 return hospitalRepository.findAll().stream().filter(u-> u.getActive() !=null && u.getActive() == false).collect(Collectors.toList());



    }


    public String Login(String email, String password) {
        Hospital hospital = hospitalRepository.findByEmail(email);
        if (hospital == null) {
            return "Hospital not found";
        }
        if (hospital.getPassword().equals(password) && hospital.getActive() == true) {
            return "Login Successful";
        }
        return "Wrong password";
    }

    public List<Hospital> findAllHospital(){
        return hospitalRepository.findAll();
    }
}
