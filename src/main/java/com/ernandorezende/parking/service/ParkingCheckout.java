package com.ernandorezende.parking.service;

import java.time.LocalDateTime;


import com.ernandorezende.parking.model.Parking;

public class ParkingCheckout {
	
	private static final Integer ONE_HOUR = 60;
	private static final Integer TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
	private static final Double ONE_HOUR_VALUE = 5.0;
	private static final Double ADDITIONAL_PER_HOUR_VALUE = 2.0;
	private static final Double DAILY_VALUE = 20.0;

	public Double getBill(Parking parking) {
		return getBill(parking.getEntryDate(), parking.getExitDate());
	}

	private Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
		return null;
	}
}
