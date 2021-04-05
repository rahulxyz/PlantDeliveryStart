package com.udacity.PlantDelivery.repository;

import com.udacity.PlantDelivery.entity.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }

    public Delivery merge(Delivery delivery){
        Delivery managedDelivery = entityManager.merge(delivery);
        return delivery;
    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }

}
