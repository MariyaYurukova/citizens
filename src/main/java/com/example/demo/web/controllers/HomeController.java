package com.example.demo.web.controllers;

import com.example.demo.domain.models.views.CitizenListViewModel;
import com.example.demo.service.CitizenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public  class HomeController extends BaseController {

  private final ModelMapper modelMapper;
  private final CitizenService citizenService;


    @Autowired
    public HomeController(ModelMapper modelMapper, CitizenService citizenService) {
        this.modelMapper = modelMapper;
        this.citizenService = citizenService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        List<CitizenListViewModel> egnNumber = this.citizenService.findAllCitizens()
                .stream()
                .map(e -> this.modelMapper.map(e, CitizenListViewModel.class))
                .collect(Collectors.toList());
modelAndView.addObject("egnN", egnNumber);
     return super.view("index", modelAndView);
    }



}
