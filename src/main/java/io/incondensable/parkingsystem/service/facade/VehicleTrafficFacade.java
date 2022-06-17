package io.incondensable.parkingsystem.service.facade;

import io.incondensable.parkingsystem.common.BusinessException;
import io.incondensable.parkingsystem.common.ExceptionMessage;
import io.incondensable.parkingsystem.repository.entity.ParkingEntity;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.service.ParkingService;
import io.incondensable.parkingsystem.service.PriceRateService;
import io.incondensable.parkingsystem.service.VehicleService;
import io.incondensable.parkingsystem.web.dto.DtoVehicleTrafficInformation;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Facade
public class VehicleTrafficFacade {

    private final VehicleService vehicleService;
    private final ParkingService parkingService;
    private final PriceRateService priceRateService;

    public VehicleTrafficFacade(VehicleService vehicleService, ParkingService parkingService, PriceRateService priceRateService) {
        this.vehicleService = vehicleService;
        this.parkingService = parkingService;
        this.priceRateService = priceRateService;
    }

    public List<DtoVehicleTrafficInformation> showVehicleTrafficInformation(String vehiclePlateNumber) {
        VehicleEntity vehicle = vehicleService.getVehicleByPlateNumber(vehiclePlateNumber);
        isVehiclePresent(vehicle, vehiclePlateNumber);

        List<ParkingEntity> vehicleTrafficList =
                parkingService.getAllParkingStatusByVehicleId(
                        vehicle.getId()
                );

        List<DtoVehicleTrafficInformation> trafficInformationList = new ArrayList<>();
        vehicleTrafficList.forEach(
                vehicleTraffic -> {
                    DtoVehicleTrafficInformation trafficInformation = new DtoVehicleTrafficInformation();

                    trafficInformation.setVehicleType(vehicleTraffic.getVehicle().getType());
                    trafficInformation.setVehiclePlateNumber(vehicleTraffic.getVehicle().getPlateNumber());
                    trafficInformation.setBasePriceRateTitle(vehicleTraffic.getBasePriceRate().getTitle());
                    trafficInformation.setEntranceTime(vehicleTraffic.getEntranceDate());
                    trafficInformation.setDepartureTime(vehicleTraffic.getDepartureDate());

                    trafficInformationList.add(trafficInformation);
                }
        );

        return trafficInformationList;
    }

    private void isVehiclePresent(VehicleEntity vehicle, String plateNumber) {
        if (vehicle == null)
            throw new BusinessException(
                    new ExceptionMessage(
                            "there.is.no.vehicle.with.this.plate.number",
                            new Object[]{plateNumber}
                    )
            );
    }

}