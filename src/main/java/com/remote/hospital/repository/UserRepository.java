package com.remote.hospital.repository;

//import antlr.collections.List;
import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String email_address);
    List<User> findAllByIsActiveAndRole(Boolean isActive, Role role);

//    User findByUsername(String username);
//
//    User findByPhoneNumber(String phoneNumber);
//
//    User findByEmail(String email);
//
//    User findByUsernameOrEmail(String username, String email);
}

