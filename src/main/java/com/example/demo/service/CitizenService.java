package com.example.demo.service;


import com.example.demo.domain.models.service.CitizenServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CitizenService  {



     List<CitizenServiceModel> findAllCitizens();


     CitizenServiceModel addComfirm(CitizenServiceModel citizenServiceModel);



     CitizenServiceModel findCitizenById(String id);

    void deleteCitizen(String id);


    CitizenServiceModel editCitizen(String id, CitizenServiceModel citizenServiceModel);

}
