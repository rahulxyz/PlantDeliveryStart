package com.udacity.PlantDelivery.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Flower extends Plant{
    private String color;

}
