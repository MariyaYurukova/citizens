package com.example.demo.domain.models.views;

import com.example.demo.domain.entities.Sex;

public class CitizenDetailsViewModel {

    private String id;
    private String firstName;
    private String lastName;
    private Integer egn;
    private Sex sex;
    private String address;


    public CitizenDetailsViewModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getEgn() {
        return egn;
    }

    public void setEgn(Integer egn) {
        this.egn = egn;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
