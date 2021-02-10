package com.ernandorezende.parking.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.ernandorezende.parking.model.Parking;
import com.ernandorezende.parking.resource.dto.ParkingCreateDTO;
import com.ernandorezende.parking.resource.dto.ParkingDTO;
import com.ernandorezende.parking.resource.mapper.ParkingMapper;
import com.ernandorezende.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingResource {
	
	private ParkingService parkingService;
	private final ParkingMapper parkingMapper;
	
	public ParkingResource(ParkingService parkingService, ParkingMapper parkingMapper){
		this.parkingService = parkingService;
		this.parkingMapper = parkingMapper;
	}
	
	@GetMapping
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		Parking parking = parkingService.findById(id);
		ParkingDTO result = parkingMapper.parkingDTO(parking);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingCreateDTO){
		Parking parking = parkingMapper.parkingCreateDTOToPrking(parkingCreateDTO);
		parking = parkingService.create(parking);
		ParkingDTO parkingDTO = parkingMapper.parkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingDTO);
	}
}
