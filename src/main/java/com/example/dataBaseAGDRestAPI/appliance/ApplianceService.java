package com.example.dataBaseAGDRestAPI.appliance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplianceService {

    ApplianceRepository applianceRepository;

    @Autowired
    public ApplianceService(ApplianceRepository applianceRepository){
        this.applianceRepository = applianceRepository;
    }

    public Appliance findById(Integer id){
        Optional<Appliance> optionalAppliance = applianceRepository.findById(id);
        return optionalAppliance.orElse(new Appliance("brak", "brak", 0));
    }

    public List<Appliance> findAll(){
        ArrayList<Appliance> appliances = new ArrayList<>();

        for(Appliance appliance : applianceRepository.findAll()) {
            appliances.add(appliance);
        }

        return appliances;
    }

    public String addAppliance(String name, String description, double value){
        Appliance appliance = new Appliance(name, description, value);
        applianceRepository.save(appliance);
        return "New appliance added: " + appliance.toString();
    }


}
