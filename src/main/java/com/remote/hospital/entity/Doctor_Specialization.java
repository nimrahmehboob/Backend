package com.remote.hospital.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Doc_Specialization")
public class Doctor_Specialization {

    @Id
    @Column(name = "Id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(name ="doctor_id" )
    private Long doctorId;

    @Column(name = "specialization_id")
    private Long specializationId;
    @Column(name = "created_on")



    private Date createdOn;
    @Column(name = "created_by")

    private  Long createdBy;
    @Column(name = "updated_on")

    private  Date updatedOn;
    @Column(name = "updated_by")

    private  Long updatedBy;
    @Column(name = "is_active")

    private Boolean isActive;



}

