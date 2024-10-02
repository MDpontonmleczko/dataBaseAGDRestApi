package com.example.dataBaseAGDRestAPI.appliance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add/appliance/{name}/{description}/{value}")
    public String addAppliance(@PathVariable("name") String name,
                               @PathVariable("description") String description,
                               @PathVariable("value") double value){
        return applianceService.addAppliance(name, description, value);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteApplianceById(@PathVariable("id") int id){
        return applianceService.deleteById(id);
    }
}
