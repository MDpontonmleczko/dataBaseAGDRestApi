package com.example.dataBaseAGDRestAPI.appliance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplianceController {

    ApplianceService applianceService;

    @Autowired
    public ApplianceController(ApplianceService applianceService){
        this.applianceService = applianceService;
    }

    @GetMapping(value = "/appliances/{id}")
    public Appliance getApplianceById(@PathVariable("id") int id){
        return applianceService.findById(id);
    }

    @GetMapping(value = "/appliances")
    public List<Appliance> getAllAppliances(){
        return applianceService.findAll();
    }

}
