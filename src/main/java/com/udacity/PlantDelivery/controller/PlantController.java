package com.udacity.PlantDelivery.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.PlantDelivery.dto.PlantDTO;
import com.udacity.PlantDelivery.entity.Plant;
import com.udacity.PlantDelivery.service.PlantService;
import com.udacity.PlantDelivery.views.Views;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

//    public PlantDTO getPlantDTO(String name){
//        Plant plant = plantService.getPlantByName(name);
//        return convertEntityToPlantDTO(plant);
//    }
//

    @GetMapping("/filterByName/{name}")
    public Plant getFilteredPlant(@PathVariable String name){
        return plantService.getPlantByName(name);
    }

    private static PlantDTO convertEntityToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plantDTO, plant);
        return plantDTO;
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }
}
