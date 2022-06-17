package io.incondensable.parkingsystem.repository.mappers.interactors;

import io.incondensable.parkingsystem.domain.model.Parking;
import io.incondensable.parkingsystem.repository.entity.ParkingEntity;
import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.repository.mappers.Mapper;
import io.incondensable.parkingsystem.repository.mappers.ParkingSystemMappers;

@Mapper
public class ParkingMapper implements ParkingSystemMappers<Parking, ParkingEntity> {

    @Override
    public Parking mapEntityToDomain(ParkingEntity entity) {
        return new Parking(
                entity.getId(),
                entity.getVehicle().getId(),
                entity.getBasePriceRate().getId(),
                entity.getEntranceDate(),
                entity.getDepartureDate(),
                entity.getFinalParkingPrice()
        );
    }

    @Override
    public ParkingEntity mapDomainToEntity(Parking domain) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(domain.getId());

        PriceRateEntity priceRateEntity = new PriceRateEntity();
        priceRateEntity.setId(domain.getBasePriceRateId());

        return new ParkingEntity(
                domain.getId(),
                vehicleEntity,
                priceRateEntity,
                domain.getEntranceDate(),
                domain.getDepartureDate(),
                domain.getFinalParkingPrice()
        );
    }

}
