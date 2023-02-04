package com.remote.hospital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;


    @Column(name="user_name")
    private String user_name;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private String phone_number;
    @Column(name="password")
    private String password;

    @Column(name="gender")
    private String gender;
    @Column(name="dob")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dob;
    @Column(name="cnic")
    private String cnic;
    @Column(name="address")
    private String address;
    @Column(name="display_image")
    private String display_image;
    @Column(name="created_on")
    private Date Created_on;
    @Column(name="created_by")
    private Long Created_by;
    @Column(name="updated_on")
    private Date Updated_on;
    @Column(name="updated_by")
    private Long Updated_by;
    @Column(name="is_active")
    private Boolean isActive;
    @Column(name="blood_group")
    private String blood_group;


    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;


    @OneToMany(mappedBy = "user")
    List<Doctor_Hospital> doctorHospitals;

    @OneToMany(mappedBy = "doc",cascade = {CascadeType.ALL})
    @JsonIgnore

    private List<Appointment> patientAppointments;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.ALL})
    @JsonIgnore

    private List<Appointment> docAppointments;



}
