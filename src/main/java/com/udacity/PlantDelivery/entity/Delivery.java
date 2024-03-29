package com.udacity.PlantDelivery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "Delivery.findByName",
        query = "select d from Delivery d where d.recipient_name = :name")
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

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plantList;

    public Delivery(){

    }

    public Delivery(String recipient_name, String address, LocalDateTime time, Boolean completed) {
        this.recipient_name=recipient_name;
        this.address = address;
        this.deliveryTime = time;
        this.completed= completed;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

}
