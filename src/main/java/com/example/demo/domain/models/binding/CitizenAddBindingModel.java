package com.example.demo.domain.models.binding;

import com.example.demo.domain.entities.Sex;

public class CitizenAddBindingModel {


    private String firstName;
    private String lastName;
    private Integer egn;
    private Sex sex;
    private String address;

    public CitizenAddBindingModel() {
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
