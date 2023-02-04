package com.remote.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class RemoteHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteHospitalApplication.class, args);
    }

}
