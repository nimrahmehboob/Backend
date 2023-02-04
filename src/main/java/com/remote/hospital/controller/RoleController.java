package com.remote.hospital.controller;

import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.User;
import com.remote.hospital.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin
public class RoleController {


    @Autowired
    RoleService roleService;

    @PostMapping("/role/user/")
    public Role getUsersRole(@RequestBody  User u)
    {
        return roleService.geUserRole(u);
    }
}
