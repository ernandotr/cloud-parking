package com.ernandorezende.parking.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
public class HomeResouce {

	@GetMapping
	public String hello() {
		return "{\"message\": \"Hello\"}";
	}
}
