package com.example.hackathon;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email){
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }

}

