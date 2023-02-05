package com.remote.hospital.service;

import com.remote.hospital.entity.Appointment;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.AppointmentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    public List<Appointment> getAllAppointments(){

        return appointmentRepository.findAll();
    }

    public List<Appointment> getPatientsAppointment(Long PatientId){

        return appointmentRepository.findByPatientIdAndIsActive(PatientId,true);
    }

    public List<Appointment> getDoctorsAppointment(Long DoctorId){

        return appointmentRepository.findByDoctorIdAndIsActive(DoctorId,true);
    }

    public ResponseEntity<?> cancelAppointment(Long AppointmentId){
        try {
            Appointment a = appointmentRepository.findById(AppointmentId).orElse(null);
            a.setIsActive(false);
            a.setUpdatedOn(new Date());
            appointmentRepository.save(a);
            return new  ResponseEntity<>("Cancelled Successfully!", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e);
            return new  ResponseEntity<>("Something Went Wrong!", HttpStatus.BAD_REQUEST);
        }
    }



    public ResponseEntity<String> bookAppointment(Appointment appointment,int day) {

        LocalDate date = LocalDate.now();


        Date d =new Date();
                d.setDate(day);
                d.setMonth(d.getMonth());
                d.setYear(d.getYear());

        for (Appointment a : getAllAppointments()) {
//            Date appdate = a.getAppDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            String appdate = formatter.format(a.getAppDate());
            String newdate = formatter.format(d);
            System.out.println("=============>"+appdate+newdate);
            if (a.getDoctorId() == appointment.getDoctorId() && a.getAppSlot().equals(appointment.getAppSlot()) && appdate.equals(newdate)) {
//                console.log("")
                System.out.println("inside");
                return new ResponseEntity<>("Already Booked!", HttpStatus.BAD_REQUEST);
            }
        }

        appointment.setCreatedOn(new Date());
        appointment.setAppDate(d);
        appointment.setIsActive(true);
        appointment.setCreatedBy(appointment.getPatientId());
        appointmentRepository.save(appointment);
        return new ResponseEntity<>("Booked Successfully!", HttpStatus.OK);
    }



//    public ResponseEntity<String> bookAppointment(Appointment appointment){
//
//
//        boolean isBooked = false;
//        for (Appointment a:
//             getAllAppointments()) {
//
//            if(a.getDoc().getId() == appointment.getDoc().getId() && a.getAppSlot() == appointment.getAppSlot() && a.getAppDate() == appointment.getAppDate()){
//                isBooked =true;
//            }
//        }
//
//        if(isBooked)
//            return new  ResponseEntity<>("Already Booked!", HttpStatus.BAD_REQUEST);
//
//        else {
//
//            appointment.setCreatedOn(new Date());
//            appointment.setCreatedBy(appointment.getPatientId());
//            appointmentRepository.save(appointment);
////        getAllAppointments().forEach(x->x.getDoc().getId() == appointment.getDoc().getId() && x.getAppTime() == appointment.getAppTime() && x.getAppDate() == appointment.getAppDate());
//            return new  ResponseEntity<>("Booked Successfully!", HttpStatus.OK);
//        }
//    }
//

}
