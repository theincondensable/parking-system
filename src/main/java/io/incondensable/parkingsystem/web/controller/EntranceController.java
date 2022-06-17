package io.incondensable.parkingsystem.web.controller;

import io.incondensable.parkingsystem.service.facade.VehicleEntranceFacade;
import io.incondensable.parkingsystem.web.dto.DtoVehicleEntranceRequest;
import io.incondensable.parkingsystem.web.dto.DtoVehicleEntranceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrance")
@Tag(description = "This Controller is responsible for entrances of vehicles.", name = "Vehicle Entrance Controller")
public class EntranceController {

    private final VehicleEntranceFacade vehicleEntranceFacade;

    public EntranceController(VehicleEntranceFacade vehicleEntranceFacade) {
        this.vehicleEntranceFacade = vehicleEntranceFacade;
    }

    @PostMapping(value = "")
    public ResponseEntity<DtoVehicleEntranceResponse> createVehicleEntrance(@RequestBody DtoVehicleEntranceRequest request) {
        return new ResponseEntity(vehicleEntranceFacade.insertVehicleAndItsEntranceInfo(request), HttpStatus.OK);
    }

}
