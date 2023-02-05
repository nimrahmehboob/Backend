package com.remote.hospital.repository;

import com.remote.hospital.entity.Appointment;
import com.remote.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
 List<Appointment> findByPatientIdAndIsActive(Long id , Boolean IsActive);
 List<Appointment> findByDoctorIdAndIsActive(Long doctorId , Boolean IsActive);
}
