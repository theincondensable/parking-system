package io.incondensable.parkingsystem.domain.model;

import java.sql.Timestamp;

public class Parking {
    private Long id;
    private Long vehicleId;
    private Long basePriceRateId;
    private Timestamp entranceDate;
    private Timestamp departureDate;
    private Double finalParkingPrice;

    public Parking() {
    }

    public Parking(Long id, Long vehicleId, Long basePriceRateId, Timestamp entranceDate, Timestamp departureDate, Double finalParkingPrice) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.basePriceRateId = basePriceRateId;
        this.entranceDate = entranceDate;
        this.departureDate = departureDate;
        this.finalParkingPrice = finalParkingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getBasePriceRateId() {
        return basePriceRateId;
    }

    public void setBasePriceRateId(Long basePriceRateId) {
        this.basePriceRateId = basePriceRateId;
    }

    public Timestamp getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Timestamp entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public Double getFinalParkingPrice() {
        return finalParkingPrice;
    }

    public void setFinalParkingPrice(Double finalParkingPrice) {
        this.finalParkingPrice = finalParkingPrice;
    }
}
