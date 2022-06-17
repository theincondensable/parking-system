package io.incondensable.parkingsystem.web.dto;

import java.util.Date;

public class DtoVehicleTrafficInformation {
    private String vehicleType;
    private String vehiclePlateNumber;
    private Date entranceTime;
    private Date departureTime;
    private String basePriceRateTitle;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getBasePriceRateTitle() {
        return basePriceRateTitle;
    }

    public void setBasePriceRateTitle(String basePriceRateTitle) {
        this.basePriceRateTitle = basePriceRateTitle;
    }
}
