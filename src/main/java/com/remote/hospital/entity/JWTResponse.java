package com.remote.hospital.entity;
import java.io.Serializable;


public class JWTResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private  String email;
    private  Long id;

    private Role role;

    public JWTResponse(String jwttoken, String email, Long id, Role role) {
        this.jwttoken = jwttoken;
        this.email = email;
        this.id = id;
        this.role = role;

    }
    public JWTResponse(String jwttoken){
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getEmail() {
        return this.email;
    }

    public Long getId() {
        return this.id;
    }


    public Role getRole() {
        return this.role;
    }
}