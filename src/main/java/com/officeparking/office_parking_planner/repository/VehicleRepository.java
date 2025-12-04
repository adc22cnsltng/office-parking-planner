package com.officeparking.office_parking_planner.repository;

import com.officeparking.office_parking_planner.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // tutti i veicoli di un certo utente
    List<Vehicle> findByOwnerUsername(String ownerUsername);
}