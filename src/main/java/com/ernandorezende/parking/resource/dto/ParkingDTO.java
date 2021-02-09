package com.ernandorezende.parking.resource.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;
}
