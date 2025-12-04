package com.officeparking.office_parking_planner.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateVehicleRequest {

    @NotBlank
    private String type;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Positive
    @Min(1)
    private double lengthMeters;

    @Positive
    @Min(1)
    private double widthMeters;

    public CreateVehicleRequest() {
    }

    // getter & setter

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
}
