package com.example.dataBaseAGDRestAPI.rest;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;
import com.example.dataBaseAGDRestAPI.service.ApplianceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplianceController {

    ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService){
        this.applianceService = applianceService;
    }

    @GetMapping(value = "/appliances/{id}")
    public ResponseEntity<Appliance> getApplianceById(@PathVariable("id") int id){

        Appliance foundAppliance = applianceService.findById(id);
        if (foundAppliance == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundAppliance);
        }
    }

    @GetMapping(value = "/appliances")
    public ResponseEntity<List<Appliance>> getAllAppliances(){

        List<Appliance> applianceList = applianceService.findAll();
        if (applianceList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(applianceList);
        }
    }

    @PostMapping(value = "/addAppliance")
    public Appliance addAppliance(@RequestBody Appliance appliance) {

        return applianceService.addAppliance(appliance);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Appliance> deleteApplianceById(@PathVariable("id") int id){

        Appliance foundAppliance = applianceService.findById(id);

        if (foundAppliance == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(applianceService.deleteById(id));
        }
    }

    @PatchMapping(value = {"update/{id}"})
    public ResponseEntity<Appliance> updateApplianceById(@PathVariable("id") int id, @RequestBody Appliance appliance) {

        Appliance foundAppliance = applianceService.findById(id);

        if (foundAppliance == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(applianceService.updateApplianceById(id, appliance));
        }
    }
}
