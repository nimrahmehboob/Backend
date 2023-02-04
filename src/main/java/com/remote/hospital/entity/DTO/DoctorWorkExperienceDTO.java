package com.remote.hospital.entity.DTO;

public class DoctorWorkExperienceDTO {

    private String HospitalInstitute;
    private String JobDesignation;
    private String From;
    private String To;




    public String getHospitalInstitute() {
        return HospitalInstitute;
    }

    public void setHospitalInstitute(String hospitalInstitute) {
        HospitalInstitute = hospitalInstitute;
    }

    public String getJobDesignation() {
        return JobDesignation;
    }

    public void setJobDesignation(String jobDesignation) {
        JobDesignation = jobDesignation;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }
}
