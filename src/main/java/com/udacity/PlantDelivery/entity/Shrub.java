package com.udacity.PlantDelivery.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
public class Shrub extends Plant{

    private int height;
    private int width;

}
