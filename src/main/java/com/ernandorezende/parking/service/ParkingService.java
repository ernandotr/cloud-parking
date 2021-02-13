package com.ernandorezende.parking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ernandorezende.parking.exception.ParkingNotFoundException;
import com.ernandorezende.parking.model.Parking;
import com.ernandorezende.parking.repository.ParkingRepository;
import com.ernandorezende.parking.resource.dto.ParkingCreateDTO;


@Service
public class ParkingService {

	private ParkingRepository repository;
	
	public ParkingService(ParkingRepository repository){
		this.repository = repository;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Parking> findAll(){
		return repository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Parking findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
	}

	@Transactional
	public Parking create(Parking parking) {
		parking.setId(getUUID());
		parking.setEntryDate(LocalDateTime.now());
		return repository.save(parking);
	}

	@Transactional
	public void delete(String id) {
		repository.delete(findById(id));
	}

	@Transactional
	public Parking update(ParkingCreateDTO parkingCreateDTO, String id) {
		Parking parking = findById(id);
		parking.setColor(parkingCreateDTO.getColor());
		parking.setState(parkingCreateDTO.getState());
		parking.setLicense(parkingCreateDTO.getLicense());
		parking.setModel(parkingCreateDTO.getModel());
		return repository.save(parking);
	}

	public Parking exit(String id) {
		Parking parking = findById(id);
		parking.setExitDate(LocalDateTime.now());
		parking.setBill(8.9);
		return repository.save(parking);
	}
	
	public Parking checkout(String id) {
		//Recuper Bill
		
		return null;
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
