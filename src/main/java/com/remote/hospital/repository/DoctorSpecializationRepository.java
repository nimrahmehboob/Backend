package com.remote.hospital.repository;

import com.remote.hospital.entity.Doctor_Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorSpecializationRepository extends JpaRepository<Doctor_Specialization, Long> {
}
