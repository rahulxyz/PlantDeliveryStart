package com.udacity.PlantDelivery.controller;

import com.udacity.PlantDelivery.dto.PlantDTO;
import com.udacity.PlantDelivery.entity.Plant;
import com.udacity.PlantDelivery.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        return convertEntityToPlantDTO(plant);
    }

    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private static PlantDTO convertEntityToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plantDTO, plant);
        return plantDTO;
    }
}
