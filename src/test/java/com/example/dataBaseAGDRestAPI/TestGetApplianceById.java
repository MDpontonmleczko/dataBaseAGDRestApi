package com.example.dataBaseAGDRestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.annotation.PostConstruct;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest (
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class TestGetApplianceById {

    @LocalServerPort
    public int serverPort;

    @PostConstruct
    public void initRestAssured() {
        RestAssured.port = serverPort;
        RestAssured.urlEncodingEnabled = false;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void givenUrl_whenGetApplianceById_thenReturnAppliancesBody() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/appliances/1")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("id", Matchers.equalTo(1))
                    .body("item", Matchers.equalTo("TV"));
    }
}
