package com.remote.hospital.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name="Appointment")
public class Appointment {


    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="doc_id", insertable=false, updatable=false)
    private User doc;
    @ManyToOne
    @JoinColumn(name="patient_id", insertable=false, updatable=false)
    private User patient;

    @Column(name = "patient_id",nullable = false)
    private Long patientId;

    @Column(name = "doc_id",nullable = false)
    private Long doctorId;

    @Column(name = "app_date")
    private Date appDate;
    @Column(name = "app_slot")
    private String appSlot;
    @Column(name = "app_reason")
    private String appReason;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "updated_by")
    private Long updatedBy;
    @Column(name= "is_active")
    private Boolean isActive;
    @Column(name= "app_fee")
    private Float appFee;
    @Column(name = "gender")
    private String gender;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "patient_name")
    private String patientName;



}
