package com.remote.hospital.controller;

import com.remote.hospital.entity.Appointment;
import com.remote.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){

      return  appointmentService.getAllAppointments();
    }

    @PostMapping("/appointment/{day}")
    public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment,@PathVariable int day){

        return appointmentService.bookAppointment(appointment,day);
    }


    @GetMapping("/appointment/patient/{id}")
    public  List<Appointment> getAppointmentsByPatientId(@PathVariable  Long id){

        return  appointmentService.getPatientsAppointment(id);
    }
    @GetMapping("/appointment/doctor/{id}")
    public  List<Appointment> getAppointmentsByDoctorId(@PathVariable  Long id){

        return  appointmentService.getDoctorsAppointment(id);
    }

    @PatchMapping("/appointment/cancel/{AppointmentId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long AppointmentId){
        return appointmentService.cancelAppointment(AppointmentId.longValue());
    }

}
