package io.incondensable.parkingsystem.repository;

import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    VehicleEntity findByPlateNumber(String plateNumber);

}
