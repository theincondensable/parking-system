package io.incondensable.parkingsystem.web.dto;

import java.sql.Timestamp;

public class DtoVehicleDepartureRequest {
    private String plateNumber;
    private Timestamp departureDate;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }
}
