package com.example.demo.service;


import com.example.demo.domain.entities.Citizen;
import com.example.demo.domain.entities.Sex;
import com.example.demo.domain.models.service.CitizenServiceModel;
import com.example.demo.domain.models.views.CitizenDetailsViewModel;
import com.example.demo.repository.CitizenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService {


    private final CitizenRepository citizenRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository, ModelMapper modelMapper) {
        this.citizenRepository = citizenRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public List<CitizenServiceModel> findAllCitizens() {
        return this.citizenRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CitizenServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public CitizenServiceModel addComfirm(CitizenServiceModel citizenServiceModel) {
        Citizen citizen = this.modelMapper.map(citizenServiceModel, Citizen.class);

        return this.modelMapper.map(this.citizenRepository.saveAndFlush(citizen), CitizenServiceModel.class);
    }


//    @Override
//    public CitizenServiceModel findCitizenByEgn(Integer egn){
//           Citizen c = this.citizenRepository.findByEgn(egn);
//
//            return this.modelMapper.map ( c, CitizenServiceModel.class);
//    }

    @Override
    public CitizenServiceModel findCitizenById(String id){
          Citizen c = this.citizenRepository.findById(id).get();

            return this.modelMapper.map ( c, CitizenServiceModel.class);
    }





    @Override
    public void deleteCitizen(String id) {
    Citizen citizen = this.citizenRepository.findById(id).get();

       this.citizenRepository.delete(citizen);


   }


    @Override
    public CitizenServiceModel editCitizen(String id, CitizenServiceModel citizenServiceModel) {
        Citizen citizen = this.citizenRepository.findById(id).get();

        citizen.setFirstName(citizenServiceModel.getFirstName());
        citizen.setLastName(citizenServiceModel.getLastName());

        citizen.setAddress(citizenServiceModel.getAddress());




        return this.modelMapper.map(this.citizenRepository.saveAndFlush(citizen), CitizenServiceModel.class);
    }


}










