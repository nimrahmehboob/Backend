package com.remote.hospital.repository;

import com.remote.hospital.entity.Hospital;
import com.remote.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository  extends JpaRepository<Hospital, Long> {


    Hospital findByEmail(String email_address);


}
