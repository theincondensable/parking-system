package io.incondensable.parkingsystem.web.dto;

public class DtoVehicleDepartureResponse extends DtoVehicleTrafficInformation {
    private Double finalParkingPrice;

    public Double getFinalParkingPrice() {
        return finalParkingPrice;
    }

    public void setFinalParkingPrice(Double finalParkingPrice) {
        this.finalParkingPrice = finalParkingPrice;
    }
}
