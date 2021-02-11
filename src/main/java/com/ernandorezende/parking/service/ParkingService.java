package com.ernandorezende.parking.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ernandorezende.parking.exception.ParkingNotFoundException;
import com.ernandorezende.parking.model.Parking;


@Service
public class ParkingService {

	private static final Map<String, Parking> parkingMap = new HashMap<>();
	
	public List<Parking> findAll(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public Parking findById(String id) {
		Parking parking = parkingMap.get(id);
		if(parking == null) {
			throw new ParkingNotFoundException(id);
		}
		return parking;
	}

	public Parking create(Parking parking) {
		parking.setEntryDate(LocalDateTime.now());
		parking.setId(getUUID());
		parkingMap.put(parking.getId(), parking);
		return parking;
	}

	public void delete(String id) {
		findById(id);
		parkingMap.remove(id);
	}

	public Parking update(Parking parking, String id) {
		Parking byID = findById(id);
		byID.setColor(parking.getColor());
		parkingMap.put(byID.getId(), byID);
		return byID;
	}

	public Parking exit(String id) {
		Parking parking = findById(id);
		parking.setExitDate(LocalDateTime.now());
		parking.setBill(8.9);
		parking.setState("CLOSED");
		parkingMap.put(id, parking);
		return parking;
	}
}
