package com.udacity.PlantDelivery.service;

import com.udacity.PlantDelivery.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        return new Plant();
    }
}
