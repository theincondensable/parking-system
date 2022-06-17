package io.incondensable.parkingsystem.domain.model;

public class Vehicle {
    private Long id;
    private String type;
    private String plateNumber;

    public Vehicle() {
    }

    public Vehicle(Long id, String type, String plateNumber) {
        this.id = id;
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public Vehicle(String type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
