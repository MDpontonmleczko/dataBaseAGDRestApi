package com.example.dataBaseAGDRestAPI.service;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;
import com.example.dataBaseAGDRestAPI.repository.ApplianceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplianceCRUDService implements ApplianceService{

    ApplianceRepository applianceRepository;

    public ApplianceCRUDService(ApplianceRepository applianceRepository){
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

    public String deleteById(int id){
        applianceRepository.deleteById(id);
        return "Appliance deleted: " + findById(id).toString();
    }

    public void updateNameById(int id, String name){
        if (applianceExistsById(id)){
            Appliance appliance = findById(id);
            appliance.setItem(name);
            applianceRepository.save(appliance);
        }

    }

    public void updateDescriptionById(int id, String description){
        if (applianceExistsById(id)){
            Appliance appliance = findById(id);
            appliance.setDescription(description);
            applianceRepository.save(appliance);
        }
    }

    public void updateValueById(int id, double value){
        if (applianceExistsById(id)){
            Appliance appliance = findById(id);
            appliance.setItem_value(value);
            applianceRepository.save(appliance);
        }
    }

    private boolean applianceExistsById(int id){
        return applianceRepository.existsById(id);
    }
}
