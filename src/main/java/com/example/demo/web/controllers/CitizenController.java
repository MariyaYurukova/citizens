package com.example.demo.web.controllers;

import com.example.demo.domain.models.binding.CitizenAddBindingModel;
import com.example.demo.domain.models.service.CitizenServiceModel;
import com.example.demo.domain.models.views.CitizenDetailsViewModel;
import com.example.demo.service.CitizenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/citizens")
public class CitizenController extends BaseController {

    private final CitizenService citizenService;
    private final ModelMapper modelMapper;



    @Autowired
    public CitizenController(CitizenService citizenService, ModelMapper modelMapper) {
        this.citizenService = citizenService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute(name= "model") CitizenAddBindingModel model){

        modelAndView.addObject("model", model);
        return super.view("add-citizen", modelAndView);
    }





    @PostMapping("/add")
    public ModelAndView addConfirm(@ModelAttribute(name = "model") CitizenAddBindingModel model, BindingResult bindingResult, ModelAndView modelAndView)  {
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("model", model);
            return  super.view("add-citizen", modelAndView);
        }

        CitizenServiceModel citizenServiceModel = this.modelMapper.map(model, CitizenServiceModel.class);
     this.citizenService.addComfirm(citizenServiceModel);

        return  super.redirect("/");
    }





    @GetMapping("/details/{id}")
    public ModelAndView detailsCitizen(@PathVariable String id, ModelAndView modelAndView) {
        CitizenDetailsViewModel citizen = this.modelMapper.map(this.citizenService.findCitizenById(id), CitizenDetailsViewModel.class);

        modelAndView.addObject("model", citizen);

        return super.view("details", modelAndView);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProductConfirm(@PathVariable String id) {

        this.citizenService.deleteCitizen(id);

        return super.redirect("/");
    }



    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable String id, ModelAndView modelAndView) {
        CitizenServiceModel citizenServiceModel = this.citizenService.findCitizenById(id);
        CitizenAddBindingModel model = this.modelMapper.map(citizenServiceModel, CitizenAddBindingModel.class);


        modelAndView.addObject("citizen", model);
       modelAndView.addObject("citizenId", id);

        return super.view("edit-citizen", modelAndView);
    }



    @PostMapping("/edit/{id}")
    public ModelAndView editCitizenConfirm(@PathVariable String id, @ModelAttribute CitizenAddBindingModel model) {
        this.citizenService.editCitizen(id, this.modelMapper.map(model, CitizenServiceModel.class));

        return super.redirect("/citizens/details/"+id);
    }

}
