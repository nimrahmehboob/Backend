package com.remote.hospital.repository;

import com.remote.hospital.entity.Doctor_Specialization;
import com.remote.hospital.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorSpecializationRepository extends JpaRepository<Doctor_Specialization, Long> {


    @Query("SELECT ds.specializationId FROM Doctor_Specialization ds WHERE ds.id = :doctorId")
    List<Specialization> findSpecializationsByDoctorId(@Param("doctorId") Long doctorId);


//    Doctor_Specialization findByDoctorId(Long id);


}
