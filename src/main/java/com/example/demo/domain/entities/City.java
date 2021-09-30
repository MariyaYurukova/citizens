package com.example.demo.domain.entities;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    private String name;
    private List<Citizen> citizens;


    public City() {
    }

    @Column(name= "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(targetEntity =  Citizen.class)
    @JoinTable(
            name = "cities_citiziens",
            joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    )
    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
