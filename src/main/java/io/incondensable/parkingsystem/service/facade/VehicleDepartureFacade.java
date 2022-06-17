package io.incondensable.parkingsystem.service.facade;

import io.incondensable.parkingsystem.common.BusinessException;
import io.incondensable.parkingsystem.common.ExceptionMessage;
import io.incondensable.parkingsystem.repository.entity.ParkingEntity;
import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.repository.entity.VehicleEntity;
import io.incondensable.parkingsystem.service.ParkingService;
import io.incondensable.parkingsystem.service.PriceRateService;
import io.incondensable.parkingsystem.service.VehicleService;
import io.incondensable.parkingsystem.web.dto.DtoVehicleDepartureRequest;
import io.incondensable.parkingsystem.web.dto.DtoVehicleDepartureResponse;

import java.sql.Timestamp;
import java.util.Calendar;

@Facade
public class VehicleDepartureFacade {

    private final VehicleService vehicleService;
    private final ParkingService parkingService;
    private final PriceRateService priceRateService;

    public VehicleDepartureFacade(
            VehicleService vehicleService,
            ParkingService parkingService,
            PriceRateService priceRateService
    ) {
        this.vehicleService = vehicleService;
        this.parkingService = parkingService;
        this.priceRateService = priceRateService;
    }

    public DtoVehicleDepartureResponse createVehicleDeparture(DtoVehicleDepartureRequest request) {
        VehicleEntity vehicle = vehicleService.getVehicleByPlateNumber(request.getPlateNumber());
        isVehiclePresent(vehicle, request.getPlateNumber());

        ParkingEntity parking = parkingService.getLastParkingStatusByVehicle(vehicle);
        parking.setDepartureDate(request.getDepartureDate());
        parkingService.updateParkingEntity(parking);

        DtoVehicleDepartureResponse response = new DtoVehicleDepartureResponse();
        fillDtoVehicleDepartureResponse(response, vehicle, parking);

        return response;
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

    private void fillDtoVehicleDepartureResponse(DtoVehicleDepartureResponse response, VehicleEntity vehicle, ParkingEntity parking) {
        PriceRateEntity priceRate = priceRateService.getByTitle(parking.getBasePriceRate().getTitle());

        response.setVehicleType(vehicle.getType());
        response.setVehiclePlateNumber(vehicle.getPlateNumber());
        response.setEntranceTime(parking.getEntranceDate());
        response.setDepartureTime(parking.getDepartureDate());
        response.setBasePriceRateTitle(parking.getBasePriceRate().getTitle());
        response.setFinalParkingPrice(calculateFinalParkingPrice(parking, priceRate));
    }

    private Double calculateFinalParkingPrice(ParkingEntity parking, PriceRateEntity priceRate) {
        Timestamp ent = parking.getEntranceDate();
        Timestamp dep = parking.getDepartureDate();

        Calendar entCal = Calendar.getInstance();
        entCal.setTimeInMillis(ent.getTime());

        Calendar depCal = Calendar.getInstance();
        depCal.setTimeInMillis(dep.getTime());

        long milliseconds = ent.getTime() - dep.getTime();
        int seconds = (int) milliseconds / 1000;
        int hours = seconds / 3600;

        return (priceRate.getDailyPriceRate() * (hours / 24));
    }

}
