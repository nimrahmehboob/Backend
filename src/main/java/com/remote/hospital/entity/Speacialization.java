package com.remote.hospital.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Specialization")
@Entity
public class Speacialization {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_on")
    private Date created_On;

    @Column(name = "created_by")
    private Long created_By;

    @Column(name = "updated_on")
    private Date updated_On;

    @Column(name = "updated_by")
    private Long updated_By;

    @Column(name = "is_active")
    private Boolean isActive;

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

    public Date getCreated_On() {
        return created_On;
    }

    public void setCreated_On(Date created_On) {
        this.created_On = created_On;
    }

    public Long getCreated_By() {
        return created_By;
    }

    public void setCreated_By(Long created_By) {
        this.created_By = created_By;
    }

    public Date getUpdated_On() {
        return updated_On;
    }

    public void setUpdated_On(Date updated_On) {
        this.updated_On = updated_On;
    }

    public Long getUpdated_By() {
        return updated_By;
    }

    public void setUpdated_By(Long updated_By) {
        this.updated_By = updated_By;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public Speacialization() {
    }

    public Speacialization(Long id, String name, Date created_On, Long created_By, Date updated_On, Long updated_By, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.created_On = created_On;
        this.created_By = created_By;
        this.updated_On = updated_On;
        this.updated_By = updated_By;
        this.isActive = isActive;
    }
}
