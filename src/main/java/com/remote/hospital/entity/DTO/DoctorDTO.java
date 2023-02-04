package com.remote.hospital.entity.DTO;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

public class DoctorDTO {


    public String name;
    public String email;
    public String password;
    public String number;
    public String gender;
    public String dob;
    public String cnic;
    public String hospitalName;
    public String fee;
    public String startTime;
    public String endTime;
    public List<String> selectDays;
    public String workExperience;
    public String education;
    public List<DoctorWorkExperienceDTO> workExperienceDTOList;
    public String skills;
    public String certifications;
    public String types;
    public List<String> area;



}
