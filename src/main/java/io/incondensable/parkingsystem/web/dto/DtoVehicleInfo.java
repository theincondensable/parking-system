package io.incondensable.parkingsystem.web.dto;

public class DtoVehicleInfo {
    private String type;
    private String plateNumber;

    public DtoVehicleInfo(String type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
