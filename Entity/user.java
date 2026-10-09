package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname; // Matches the spelling from your instructions
    private String address;
    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(String fname, String lname,String address) {
        this.fname = fname;
        this.lname = lname;
        this.address=address;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return fname;
    }

    public void setFirstname(String firstname) {
        this.fname = fname;
    }
    public String getLasttname() {
        return lname;
    }

    public void setLasttname(String lasttname) {
        this.lname = lname;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
