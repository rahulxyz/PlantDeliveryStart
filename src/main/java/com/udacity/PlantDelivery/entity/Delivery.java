package com.udacity.PlantDelivery.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "delivery")
    private List<Plant> plantList;

}
