package com.officeparking.office_parking_planner.service.impl;

import com.officeparking.office_parking_planner.dto.request.CreateVehicleRequest;
import com.officeparking.office_parking_planner.dto.response.VehicleResponse;
import com.officeparking.office_parking_planner.model.entity.Vehicle;
import com.officeparking.office_parking_planner.repository.VehicleRepository;
import com.officeparking.office_parking_planner.service.VehicleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleResponse createVehicleForCurrentUser(CreateVehicleRequest request) {
        String currentUsername = getCurrentUsername();

        // Creiamo l'entità Vehicle legata all'utente corrente
        Vehicle vehicle = new Vehicle(
                currentUsername,
                request.getType(),
                request.getBrand(),
                request.getModel(),
                request.getLengthMeters(),
                request.getWidthMeters()
        );

        Vehicle saved = vehicleRepository.save(vehicle);

        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponse> getVehiclesForCurrentUser() {
        String currentUsername = getCurrentUsername();

        return vehicleRepository.findByOwnerUsername(currentUsername)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Recupera lo username dell'utente autenticato dal SecurityContext.
     * Se non c'è un utente autenticato, solleva un'eccezione.
     */
    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("Nessun utente autenticato trovato nel SecurityContext");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }

        // Fallback (es. principal è una stringa)
        return authentication.getName();
    }

    /**
     * Mappa l'entità Vehicle al DTO VehicleResponse.
     */
    private VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getType(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getLengthMeters(),
                vehicle.getWidthMeters(),
                vehicle.getFootprintSqm()
        );
    }
}
