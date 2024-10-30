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
        return optionalAppliance.orElse(null);
    }

    public List<Appliance> findAll(){
        ArrayList<Appliance> appliances = new ArrayList<>();

        for(Appliance appliance : applianceRepository.findAll()) {
            appliances.add(appliance);
        }

        return appliances;
    }

    public Appliance addAppliance(Appliance appliance){
        applianceRepository.save(appliance);
        return appliance;
    }

    public Appliance deleteById(int id){
        Appliance deletedAppliance = findById(id);
        applianceRepository.deleteById(id);
        return deletedAppliance;
    }

    public Appliance updateApplianceById(int id, Appliance newAppliance) {
        Appliance currentAppliance = findById(id);
        currentAppliance.setItem(newAppliance.getItem());
        currentAppliance.setDescription(newAppliance.getDescription());
        currentAppliance.setItem_value(newAppliance.getItem_value());
        applianceRepository.save(currentAppliance);
        return findById(id);
    }
}
