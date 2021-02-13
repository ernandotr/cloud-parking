package com.ernandorezende.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ernandorezende.parking.model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String>{

}
