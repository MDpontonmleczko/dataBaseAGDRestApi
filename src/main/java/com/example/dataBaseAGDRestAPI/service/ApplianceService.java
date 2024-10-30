package com.example.dataBaseAGDRestAPI.service;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplianceService {

    Appliance findById(Integer id);
    List<Appliance> findAll();
    Appliance addAppliance(Appliance appliance);
    Appliance deleteById(int id);
    Appliance updateApplianceById(int id, Appliance appliance);
}
