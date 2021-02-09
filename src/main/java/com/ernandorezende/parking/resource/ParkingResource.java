package com.ernandorezende.parking.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ernandorezende.parking.model.Parking;
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
	public List<ParkingDTO> findAll(){
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return result;
		
	}
}
