package com.remote.hospital.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Doc_Hospital")

public class Doctor_Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    Hospital hospital;




    @ManyToOne
    @JoinColumn(name = "doctor_id")
    User user;

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



}
