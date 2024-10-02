package com.example.dataBaseAGDRestAPI.appliance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PatchMapping(value = {"update/{id}/{name}/{description}/{value}",
            "update/{id}/{name}//",
            "update/{id}///{value}",
            "update/{id}//{description}/"})
    public String updateApplianceById(@PathVariable("id") int id,
                                      @PathVariable(value = "name", required = false) String name,
                                      @PathVariable(value = "description", required = false) String description,
                                      @PathVariable(value = "value", required = false) Optional<Double> value){

        Appliance oldAppliance = new Appliance(
                applianceService.findById(id).getItem(),
                applianceService.findById(id).getDescription(),
                applianceService.findById(id).getItem_value());


        if (name != null){
            applianceService.updateNameById(id, name);
        }
        if (description != null){
            applianceService.updateDescriptionById(id, description);
        }
        value.ifPresent(doubleValue -> applianceService.updateValueById(id, doubleValue));

        return "Appliance updated from: " + oldAppliance + " to: " + applianceService.findById(id);
    }
}
