package com.ernandorezende.parking.resource;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import com.ernandorezende.parking.resource.dto.ParkingCreateDTO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingResourceTest extends AbstractContainerBase{

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    void findAll() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(200);

        assertTrue(true);
    }

    @Test
    void create() {
    	var createDTO  = new ParkingCreateDTO();
    	createDTO.setColor("AMARELO");
    	createDTO.setLicense("POQ-3368");
    	createDTO.setModel("BRASILIA");
    	createDTO.setState("SP");
    	RestAssured.given()
        .when()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(createDTO)
        .post("/parking")
        .then()
        .statusCode(201)
        .body("license", Matchers.equalTo("POQ-3368"))
        .body("model", Matchers.equalTo("BRASILIA"))
        .body("state", Matchers.equalTo("SP"))
    	.body("color", Matchers.equalTo("AMARELO"));

        assertTrue(true);
    }
}
