package com.officeparking.office_parking_planner.dto.response;

public class VehicleResponse {

    private Long id;
    private String type;
    private String brand;
    private String model;
    private double lengthMeters;
    private double widthMeters;
    private double footprintSqm;

    public VehicleResponse() {
    }

    public VehicleResponse(
            Long id,
            String type,
            String brand,
            String model,
            double lengthMeters,
            double widthMeters,
            double footprintSqm
    ) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.lengthMeters = lengthMeters;
        this.widthMeters = widthMeters;
        this.footprintSqm = footprintSqm;
    }

    // getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getFootprintSqm() {
        return footprintSqm;
    }

    public void setFootprintSqm(double footprintSqm) {
        this.footprintSqm = footprintSqm;
    }
}
