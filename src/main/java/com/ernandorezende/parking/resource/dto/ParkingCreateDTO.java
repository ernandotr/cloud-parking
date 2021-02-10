package com.ernandorezende.parking.resource.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingCreateDTO {

	private String license;
	private String state;
	private String model;
	private String color;
}
