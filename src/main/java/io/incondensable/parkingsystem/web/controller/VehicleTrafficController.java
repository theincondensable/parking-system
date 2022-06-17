package io.incondensable.parkingsystem.web.controller;

import io.incondensable.parkingsystem.service.facade.VehicleTrafficFacade;
import io.incondensable.parkingsystem.web.dto.DtoVehicleTrafficInformation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/traffic")
@Tag(description = "This Controller is responsible for monitoring of vehicles traffics.", name = "Vehicle Traffic Controller")
public class VehicleTrafficController {

    private final VehicleTrafficFacade vehicleTrafficFacade;

    public VehicleTrafficController(VehicleTrafficFacade vehicleTrafficFacade) {
        this.vehicleTrafficFacade = vehicleTrafficFacade;
    }

    @GetMapping(value = "/{vehiclePlateNumber}")
    public ResponseEntity<List<DtoVehicleTrafficInformation>> getVehicleTrafficInformation(@PathVariable String vehiclePlateNumber) {
        return new ResponseEntity<>(
                vehicleTrafficFacade.showVehicleTrafficInformation(vehiclePlateNumber),
                HttpStatus.OK);
    }

}
