package io.incondensable.parkingsystem.service;

import io.incondensable.parkingsystem.domain.model.Vehicle;
import io.incondensable.parkingsystem.repository.VehicleRepository;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.repository.mappers.interactors.VehicleMapper;
import io.incondensable.parkingsystem.web.dto.DtoVehicleInfo;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;
    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper mapper) {
        this.repository = vehicleRepository;
        this.mapper = mapper;
    }

    public VehicleEntity createVehicle(DtoVehicleInfo vehicleInfo) {
        Vehicle domain = new Vehicle();

        domain.setType(vehicleInfo.getType());
        domain.setPlateNumber(vehicleInfo.getPlateNumber());

        VehicleEntity entity = mapper.mapDomainToEntity(domain);

        return repository.save(entity);
    }

    public VehicleEntity getVehicleById(Long vehicleId) {
        validateInput(vehicleId);

        return repository.findById(vehicleId).get();
    }

    public VehicleEntity getVehicleByPlateNumber(String plateNumber) {
        validateInput(plateNumber);

        return repository.findByPlateNumber(plateNumber);
    }

    private void validateInput(Object input) {
        if (input == null)
            throw new RuntimeException("The Input is Empty!");
    }

}
