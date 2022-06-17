package io.incondensable.parkingsystem.repository;

import io.incondensable.parkingsystem.repository.entity.ParkingEntity;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {

    ParkingEntity findTopByVehicleOrderByIdDesc(VehicleEntity vehicle);

    List<ParkingEntity> findAllByVehicleId(Long vehicleId);

    @Modifying
    @Query("update ParkingEntity p set p.departureDate = ?1 where p.id = ?2")
    ParkingEntity setDepartureDate(Timestamp departureDate, Long parkingId);

}
