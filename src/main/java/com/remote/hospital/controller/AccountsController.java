package com.remote.hospital.controller;

import com.remote.hospital.config.JWTTokenUtil;
import com.remote.hospital.entity.Hospital;
import com.remote.hospital.entity.JWTRequest;
import com.remote.hospital.entity.JWTResponse;
import com.remote.hospital.entity.User;
import com.remote.hospital.service.HospitalService;
import com.remote.hospital.service.JWTService;
import com.remote.hospital.service.RoleService;
import com.remote.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
public class AccountsController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTService userDetailsService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {

        try
        {
           // authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JWTResponse(
                    token,
                    userDetails.getUsername(),
                    userService.getUserByEmail(userDetails.getUsername()).getId(),
                    userService.getUserByEmail(userDetails.getUsername()).getRole()


            ));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }






    }


    @RequestMapping(value = "/login/authenticate/hospital", method = RequestMethod.POST)
    public ResponseEntity<?> createHospitalAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {

        try
        {
            System.out.println("hospital");
//            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadHospitalByEmail(authenticationRequest.getEmail());
            System.out.println(userDetails);
            System.out.println(authenticationRequest.getEmail());
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JWTResponse(
                    token

            ));        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }






    }

    @Autowired
    UserService userService;
    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {

        if (userService.getUserByEmail(user.getEmailAddress()) != null) {
            return ResponseEntity.ok("User already exists");
        }

        user.setCreated_on(new Date());
        user.setCreated_by(Integer.toUnsignedLong(0));
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @Autowired

    public HospitalService hospitalservice;
    @RequestMapping(value = "/register/hospital", method = RequestMethod.POST)
    public ResponseEntity<?> saveHospital(@RequestBody Hospital hospital) throws Exception {

        if (hospitalservice.getHospitalByEmail(hospital.getEmail()) != null) {
            return ResponseEntity.ok("Email already exists");
        }

        hospital.setCreatedOn(new Date());

        return ResponseEntity.ok(userDetailsService.saveHospital(hospital));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
