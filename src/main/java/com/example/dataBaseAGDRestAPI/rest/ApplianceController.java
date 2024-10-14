package com.example.dataBaseAGDRestAPI.rest;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;
import com.example.dataBaseAGDRestAPI.service.ApplianceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApplianceController {

    ApplianceService applianceService;

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

    @PostMapping(value = "/add/appliance/{item}/{description}/{value}")
    public String addAppliance(@PathVariable("item") String item,
                               @PathVariable("description") String description,
                               @PathVariable("value") double value){
        return applianceService.addAppliance(item, description, value);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteApplianceById(@PathVariable("id") int id){
        return applianceService.deleteById(id);
    }

    @PatchMapping(value = {"update/{id}/{name}/{description}/{value}",
            "update/{id}/{item}//",
            "update/{id}///{value}",
            "update/{id}//{description}/"})
    public String updateApplianceById(@PathVariable("id") int id,
                                      @PathVariable(value = "item", required = false) String item,
                                      @PathVariable(value = "description", required = false) String description,
                                      @PathVariable(value = "value", required = false) Optional<Double> value){

        Appliance oldAppliance = new Appliance(
                applianceService.findById(id).getItem(),
                applianceService.findById(id).getDescription(),
                applianceService.findById(id).getItem_value());


        if (item != null){
            applianceService.updateNameById(id, item);
        }
        if (description != null){
            applianceService.updateDescriptionById(id, description);
        }
        value.ifPresent(doubleValue -> applianceService.updateValueById(id, doubleValue));

        return "Appliance updated from: " + oldAppliance + " to: " + applianceService.findById(id);
    }
}
