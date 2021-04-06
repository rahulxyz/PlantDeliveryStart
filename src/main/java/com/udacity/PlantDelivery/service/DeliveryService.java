package com.udacity.PlantDelivery.service;

import com.udacity.PlantDelivery.entity.Delivery;
import com.udacity.PlantDelivery.projection.RecipientAndPrice;
import com.udacity.PlantDelivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery){
        delivery.getPlantList().forEach(plant->plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }
}
