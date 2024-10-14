package com.example.dataBaseAGDRestAPI.repository;

import com.example.dataBaseAGDRestAPI.appliance.Appliance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends CrudRepository<Appliance, Integer> {
}
