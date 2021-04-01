package com.udacity.PlantDelivery.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="plant")
public class Flower {
    @Id
    @GeneratedValue
    private Long id; //unique + auto generated

    @Nationalized
    private String name;//support international language char

    private String color;

    @Column(precision=12, scale=4)
    private BigDecimal price; //DECIMAL column with 12 precision and 4 decimal places (scale)
}
