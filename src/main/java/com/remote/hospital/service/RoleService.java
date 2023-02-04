package com.remote.hospital.service;

import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role geUserRole(User u){
       return roleRepository.findByUsers(u);
    }
}
