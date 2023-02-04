package com.remote.hospital.repository;

import com.remote.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String email_address);

//    User findByUsername(String username);
//
//    User findByPhoneNumber(String phoneNumber);
//
//    User findByEmail(String email);
//
//    User findByUsernameOrEmail(String username, String email);
}

