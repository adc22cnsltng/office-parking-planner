package com.officeparking.office_parking_planner.service;

import com.officeparking.office_parking_planner.dto.request.CreateVehicleRequest;
import com.officeparking.office_parking_planner.dto.response.VehicleResponse;

import java.util.List;

public interface VehicleService {

    VehicleResponse createVehicleForCurrentUser(CreateVehicleRequest request);

    List<VehicleResponse> getVehiclesForCurrentUser();
}
