package com.officeparking.office_parking_planner.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // username dell'utente proprietario (per ora, con Basic Auth)
    @Column(nullable = false)
    private String ownerUsername;

    @Column(nullable = false)
    private String type;   // es. CAR, MOTORBIKE, VAN... (da cambiare con enum in futuro)

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Double lengthMeters;

    @Column(nullable = false)
    private Double widthMeters;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Costruttore vuoto richiesto da JPA
    protected Vehicle() {
    }

    // Costruttore di comodo (non obbligatorio, ma utile)
    public Vehicle(
            String ownerUsername,
            String type,
            String brand,
            String model,
            double lengthMeters,
            double widthMeters
    ) {
        this.ownerUsername = ownerUsername;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.lengthMeters = lengthMeters;
        this.widthMeters = widthMeters;
        this.createdAt = LocalDateTime.now();
    }

    // GETTER e SETTER

    public Long getId() {
        return id;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public void setLengthMeters(double lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    public double getWidthMeters() {
        return widthMeters;
    }

    public void setWidthMeters(double widthMeters) {
        this.widthMeters = widthMeters;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // proprietà derivata (non salvata nel DB)
    @Transient
    public double getFootprintSqm() {
        return lengthMeters * widthMeters;
    }
}