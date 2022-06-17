package io.incondensable.parkingsystem.service.facade;

import io.incondensable.parkingsystem.common.BusinessException;
import io.incondensable.parkingsystem.common.ExceptionMessage;
import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.service.ParkingService;
import io.incondensable.parkingsystem.service.PriceRateService;
import io.incondensable.parkingsystem.service.VehicleService;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.web.dto.DtoVehicleEntranceRequest;
import io.incondensable.parkingsystem.web.dto.DtoVehicleEntranceResponse;
import org.springframework.http.HttpStatus;

@Facade
public class VehicleEntranceFacade {

    private final VehicleService vehicleService;
    private final PriceRateService priceRateService;
    private final ParkingService parkingService;

    public VehicleEntranceFacade(
            VehicleService vehicleService,
            ParkingService parkingService,
            PriceRateService priceRateRepository
    ) {
        this.vehicleService = vehicleService;
        this.priceRateService = priceRateRepository;
        this.parkingService = parkingService;
    }

    public DtoVehicleEntranceResponse insertVehicleAndItsEntranceInfo(DtoVehicleEntranceRequest request) {
        VehicleEntity vehicle =
                vehicleService.getVehicleByPlateNumber(
                        request.getVehicle().getPlateNumber()
                );

        isVehiclePresent(vehicle, request.getVehicle().getPlateNumber());
        vehicle = vehicleService.createVehicle(request.getVehicle());

        PriceRateEntity basePriceRate = priceRateService
                .getByTitle(request.getBasePriceRateTitle());

        parkingService.insertVehicleEntranceDate(request, vehicle, basePriceRate);

        DtoVehicleEntranceResponse response = new DtoVehicleEntranceResponse();
        response.setVehicle(request.getVehicle());
        response.setEntranceDate(request.getEntranceDate());
        response.setBasePriceRateTitle(basePriceRate.getTitle());

        return response;
    }

    private void isVehiclePresent(VehicleEntity vehicle, String plateNumber) {
        if (vehicle != null)
            throw new BusinessException(
                    new ExceptionMessage(
                            "a.vehicle.is.already.inserted.with.this.plate.number",
                            new Object[]{plateNumber}
                    )
            );
    }

}
