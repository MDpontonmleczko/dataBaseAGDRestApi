package com.example.dataBaseAGDRestAPI.service;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;

import java.util.List;

public interface ApplianceService {

    Appliance findById(Integer id);
    List<Appliance> findAll();
    String addAppliance(String name, String description, double value);
    String deleteById(int id);
    void updateNameById(int id, String name);
    void updateDescriptionById(int id, String description);
    void updateValueById(int id, double value);
}
