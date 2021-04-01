package com.udacity.PlantDelivery.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String recipient_name; //support international language char

    @Column(name="address_full", length=512)
    private String address; //address_full column, 500 character

    @Type(type = "yes_no")
    private Boolean completed;  // Y/N

    private LocalDateTime deliveryTime; // includes both date and time - simpler than having two separate fields

}
