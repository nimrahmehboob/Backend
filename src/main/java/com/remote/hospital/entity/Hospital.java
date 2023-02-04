package com.remote.hospital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Hospital")
public class Hospital
{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


@Column(name="name")
    private String name;

    @Column(name="account_manager_name")
    private String accountManagerName;


@Column(name="location")
    private String location;

@Column(name = "hospital_registeration_id")

    private String hospitalRegistrationId;


@Column(name="phone_number")
    private String phoneNumber;



@Column(name = "email")

    private String email;

@Column(name="Type")
    private String type;


@Column(name = "opening_time")

@JsonFormat(pattern="hh:mm")
    private LocalTime openingTime;



@JsonFormat(pattern="hh:mm")
@Column(name = "closing_time")
    private LocalTime closingTime;


@Column(name="image")
private String image;


@Column(name="created_on")
private Date createdOn;

@Column(name="created_by")
private Long createdBy;


@Column(name="updated_on")
private Date updatedOn;


@Column(name="updated_by")
private Long updatedBy;

@Column(name="is_active")
private Boolean isActive;


@OneToMany(mappedBy = "hospital")
List<Doctor_Hospital> doctorHospitals;
@Column(name="password")
private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHospitalRegistrationId() {
        return hospitalRegistrationId;
    }

    public void setHospitalRegistrationId(String hospitalRegistrationId) {
        this.hospitalRegistrationId = hospitalRegistrationId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public List<Doctor_Hospital> getDoctorHospitals() {
        return doctorHospitals;
    }

    public void setDoctorHospitals(List<Doctor_Hospital> doctorHospitals) {
        this.doctorHospitals = doctorHospitals;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getAccountManagerName() {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName) {
        this.accountManagerName = accountManagerName;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Hospital() {
    }

    public Hospital(Long id, String name, String accountManagerName, String location, String hospitalRegistrationId, String phoneNumber, String email, String type, LocalTime openingTime, LocalTime closingTime, String image, Date createdOn, Long createdBy, Date updatedOn, Long updatedBy, Boolean isActive, List<Doctor_Hospital> doctorHospitals, String password) {
        this.id = id;
        this.name = name;
        this.accountManagerName = accountManagerName;
        this.location = location;
        this.hospitalRegistrationId = hospitalRegistrationId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.image = image;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
        this.isActive = isActive;
        this.doctorHospitals = doctorHospitals;
        this.password = password;
    }
}

