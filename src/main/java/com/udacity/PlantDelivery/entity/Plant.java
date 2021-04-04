package com.udacity.PlantDelivery.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id; //unique + auto generated

    @Nationalized
    private String name;//support international language char

    @Column(precision=12, scale=4)
    private BigDecimal price; //DECIMAL column with 12 precision and 4 decimal places (scale)

    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
}
