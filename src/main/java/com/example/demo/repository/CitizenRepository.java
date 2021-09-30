package com.example.demo.repository;

import com.example.demo.domain.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CitizenRepository  extends JpaRepository<Citizen, String> {





}
