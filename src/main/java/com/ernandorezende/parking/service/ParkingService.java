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

	private static Map<String, Parking> parkingMap = new HashMap<>();
	
	static {
		var id = getUUID();
		var id2 = getUUID();
		Parking parking = new Parking(id, "POQ-6368","MG","Mobi", "WHITE", null, null, null);
		Parking parking2 = new Parking(id2, "POH-3368","MG","Corolla", "BLACK", null, null, null);
		parkingMap.put(id, parking);
		parkingMap.put(id2, parking2);
	}
	
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
}
