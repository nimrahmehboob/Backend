package com.remote.hospital.service;


import com.remote.hospital.entity.Speacialization;
import com.remote.hospital.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    public SpecializationRepository sr;



    public List<Speacialization> GetAllspecialtion(){
        return sr.findAll();
    }

    public Speacialization CreateSpecialization(Speacialization s){
        return sr.save(s);
    }


}
