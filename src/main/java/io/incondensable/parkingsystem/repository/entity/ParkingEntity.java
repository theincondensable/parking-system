package io.incondensable.parkingsystem.repository.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PARKING")
public class ParkingEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_price_rate_id")
    private PriceRateEntity basePriceRate;

    @Column(name = "entrance_date")
    private Timestamp entranceDate;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    @Column(name = "final_parking_price")
    private Double finalParkingPrice;

    public ParkingEntity() {
    }

    public ParkingEntity(Long id, VehicleEntity vehicle, PriceRateEntity basePriceRate, Timestamp entranceDate, Timestamp departureDate, Double finalParkingPrice) {
        this.id = id;
        this.vehicle = vehicle;
        this.basePriceRate = basePriceRate;
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

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicleId) {
        this.vehicle = vehicleId;
    }

    public PriceRateEntity getBasePriceRate() {
        return basePriceRate;
    }

    public void setBasePriceRate(PriceRateEntity basePriceRateId) {
        this.basePriceRate = basePriceRateId;
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
