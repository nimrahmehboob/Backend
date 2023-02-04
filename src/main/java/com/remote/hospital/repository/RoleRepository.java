package com.remote.hospital.repository;

import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {

 Role findByUsers(User u);
}
