package com.ernandorezende.parking.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResouce {

	@GetMapping
	public String hello() {
		return "<h1>Hello World</h1> <hr/>";
	}
}
