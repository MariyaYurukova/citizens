package com.example.demo.domain.entities;


import javax.persistence.*;

@Entity
@Table(name = "citizens")
public class Citizen extends BaseEntity {


    private String firstName;
    private String lastName;
    private Integer egn;
    private Sex sex;
    private String address;


    public Citizen() {
    }

    @Column(name= "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name= "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name= "EGN")
    public Integer getEgn() {
        return egn;
    }

    public void setEgn(Integer egn) {
        this.egn = egn;
    }


    @Enumerated(EnumType.STRING)
    @Column(name= "sex")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    @Column(name= "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
