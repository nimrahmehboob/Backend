package com.remote.hospital.service;

import com.remote.hospital.entity.Appointment;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    public List<Appointment> getAllAppointments(){

        return appointmentRepository.findAll();
    }

    public List<Appointment> getPatientsAppointment(User u){

        return appointmentRepository.findByPatient(u);
    }

}
