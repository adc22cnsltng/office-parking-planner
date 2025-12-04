package com.officeparking.office_parking_planner.controller;

import com.officeparking.office_parking_planner.dto.request.CreateVehicleRequest;
import com.officeparking.office_parking_planner.dto.response.VehicleResponse;
import com.officeparking.office_parking_planner.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(
            @Valid @RequestBody CreateVehicleRequest request
    ) {
        VehicleResponse response = vehicleService.createVehicleForCurrentUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getMyVehicles() {
        List<VehicleResponse> vehicles = vehicleService.getVehiclesForCurrentUser();
        return ResponseEntity.ok(vehicles);
    }
}
