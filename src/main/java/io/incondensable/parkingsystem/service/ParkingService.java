package io.incondensable.parkingsystem.service;

import io.incondensable.parkingsystem.repository.ParkingRepository;
import io.incondensable.parkingsystem.repository.entity.ParkingEntity;
import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.web.dto.DtoVehicleEntranceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public void insertVehicleEntranceDate(
            DtoVehicleEntranceRequest request,
            VehicleEntity vehicle,
            PriceRateEntity basePriceRate
    ) {
        ParkingEntity entity = new ParkingEntity();
        entity.setVehicle(vehicle);
        entity.setBasePriceRate(basePriceRate);
        entity.setEntranceDate(request.getEntranceDate());

        parkingRepository.save(entity);
    }

    public ParkingEntity getLastParkingStatusByVehicle(VehicleEntity vehicle) {
        return parkingRepository.findTopByVehicleOrderByIdDesc(vehicle);
    }

    public List<ParkingEntity> getAllParkingStatusByVehicleId(Long vehicleId) {
        return parkingRepository.findAllByVehicleId(vehicleId);
    }

    public ParkingEntity updateParkingEntity(ParkingEntity parkingEntity) {
        return parkingRepository.setDepartureDate(parkingEntity.getDepartureDate(), parkingEntity.getId());
    }

}
