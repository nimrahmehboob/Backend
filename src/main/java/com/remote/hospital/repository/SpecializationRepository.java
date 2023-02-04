package com.remote.hospital.repository;

//import com.remote.hospital.entity.Speacialization;
import com.remote.hospital.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository <Specialization,Long>{
    Specialization findByName(String specialization);
}
