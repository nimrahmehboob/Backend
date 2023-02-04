package com.remote.hospital.controller;

import com.remote.hospital.entity.DTO.DoctorDTO;
import com.remote.hospital.entity.User;
import com.remote.hospital.service.DoctorSpecializationService;
import com.remote.hospital.service.JWTService;
import com.remote.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private JWTService userDetailsService;

    @Autowired
    private DoctorSpecializationService doctorSpecializationService;


    @GetMapping("/user")
    public List<User>  getAllUsers(){



        return userService.findAllUser();

    }
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){


       return userService.saveUser(user);

    }

    @PostMapping("/doctor")
    public String saveDoctor(@RequestBody DoctorDTO doctorDTO){



      User ud= userDetailsService.saveDoctor(doctorDTO);

        if(ud!=null)
            return  "Success";
        else
            return "Failed";

//        return "something";




    }


    @PostMapping("/login")
    public User Login(@RequestBody User user) {

        return userService.Login(user.getEmailAddress(), user.getPassword());
    }


    @GetMapping("/doctors")
    public  List<User> getDoctors(){
        return userService.getDoctors();

    }

    @GetMapping("/all-doctors/")
    public  List<DoctorDTO> getAllDoctors(){

        return userService.getAllDoctorsWithAreas();
    }

    @RequestMapping(value = "/register/doctor", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody DoctorDTO user) throws Exception {

        User u = new User();
        if (userService.getUserByEmail(user.email) != null) {
            return ResponseEntity.ok("User already exists with this email!");
        }



        return ResponseEntity.ok(userDetailsService.saveDoctor(user));
    }




    @GetMapping("/doctor-specialization/{doctorID}")
    public  List<?> getDoctorsSpecialization(@PathVariable String doctorID){

       return doctorSpecializationService.getListOfDoctorSpecializationsByDoctorId(Long.parseLong(doctorID));
    }

}



