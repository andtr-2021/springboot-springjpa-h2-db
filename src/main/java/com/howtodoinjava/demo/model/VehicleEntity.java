package com.howtodoinjava.demo.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_VEHICLES")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public VehicleEntity() {

    }

    @Column(name="name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="plate")
    private String plate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
