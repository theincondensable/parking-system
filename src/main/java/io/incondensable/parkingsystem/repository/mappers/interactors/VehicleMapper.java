package io.incondensable.parkingsystem.repository.mappers.interactors;

import io.incondensable.parkingsystem.domain.model.Vehicle;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.repository.mappers.Mapper;
import io.incondensable.parkingsystem.repository.mappers.ParkingSystemMappers;

@Mapper
public class VehicleMapper implements ParkingSystemMappers<Vehicle, VehicleEntity> {

    @Override
    public Vehicle mapEntityToDomain(VehicleEntity entity) {
        return new Vehicle(
                entity.getId(),
                entity.getType(),
                entity.getPlateNumber()
        );
    }

    @Override
    public VehicleEntity mapDomainToEntity(Vehicle domain) {
        return new VehicleEntity(
                domain.getId(),
                domain.getType(),
                domain.getPlateNumber()
        );
    }

}
