package io.incondensable.parkingsystem.web.controller;

import io.incondensable.parkingsystem.service.facade.VehicleDepartureFacade;
import io.incondensable.parkingsystem.web.dto.DtoVehicleDepartureRequest;
import io.incondensable.parkingsystem.web.dto.DtoVehicleDepartureResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departure")
@Tag(description = "This Controller is responsible for departures of vehicles.", name = "Vehicle Departure Controller")
public class DepartureController {

    private final VehicleDepartureFacade vehicleDepartureFacade;

    public DepartureController(VehicleDepartureFacade vehicleDepartureFacade) {
        this.vehicleDepartureFacade = vehicleDepartureFacade;
    }

    @PostMapping(value = "")
    public ResponseEntity<DtoVehicleDepartureResponse> getVehicleDeparture(@RequestBody DtoVehicleDepartureRequest request) {
        return new ResponseEntity<>(vehicleDepartureFacade.createVehicleDeparture(request), HttpStatus.OK);
    }

}
