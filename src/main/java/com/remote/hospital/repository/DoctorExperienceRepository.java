package com.remote.hospital.repository;

import com.remote.hospital.entity.DoctorExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorExperienceRepository extends JpaRepository <DoctorExperience,Long> {
}
