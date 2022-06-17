package io.incondensable.parkingsystem.web.dto;

import java.sql.Timestamp;

public class DtoVehicleEntranceRequest {
    private DtoVehicleInfo vehicle;
    private Timestamp entranceDate;
    private String basePriceRateTitle;

    public DtoVehicleInfo getVehicle() {
        return vehicle;
    }

    public void setVehicle(DtoVehicleInfo vehicle) {
        this.vehicle = vehicle;
    }

    public Timestamp getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Timestamp entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getBasePriceRateTitle() {
        return basePriceRateTitle;
    }

    public void setBasePriceRateTitle(String basePriceRateTitle) {
        this.basePriceRateTitle = basePriceRateTitle;
    }
}
