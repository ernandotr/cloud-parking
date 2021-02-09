package com.ernandorezende.parking.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResouce {

	@GetMapping
	public String hello() {
		return "{\"message\": \"Hello\"}";
	}
}
