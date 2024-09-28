package com.example.dataBaseAGDRestAPI.appliance;

import com.example.dataBaseAGDRestAPI.Repository;

import java.util.List;

public interface ApplianceRepository extends Repository<Appliance, Integer> {

    Appliance create(Appliance appliance);
    Appliance delete(Appliance appliance);
    Appliance update(Appliance appliance);
    Appliance readById(Integer id);
    Appliance readByName(String name);
    List<Appliance> read();
}
