package com.remote.hospital.service;

import com.remote.hospital.repository.DoctorSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorSpecializationService {

        @Autowired
        public DoctorSpecializationRepository doctorSpecializationRepository;



        public List<?> getListOfDoctorSpecializationsByDoctorId(Long id)
        {

         return    doctorSpecializationRepository.findAll()
                 .stream()
                 .filter(x->x.getDoctorId() == id)
                 .collect(Collectors.toList());
        }



}
