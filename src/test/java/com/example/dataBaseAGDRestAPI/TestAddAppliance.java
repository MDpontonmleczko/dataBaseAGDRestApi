package com.example.dataBaseAGDRestAPI;

import com.example.dataBaseAGDRestAPI.appliance.ApplianceController;
import com.example.dataBaseAGDRestAPI.appliance.ApplianceService;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import jakarta.annotation.PostConstruct;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class TestAddAppliance {

    @LocalServerPort
    public int serverPort;

    @Autowired
    private MockMvc mvc;

    @MockBean
    ApplianceService applianceService;

    @InjectMocks
    ApplianceController applianceController;

    @PostConstruct
    public void initRestAssured(){
        RestAssured.port = serverPort;
        RestAssured.urlEncodingEnabled = false;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssuredMockMvc.standaloneSetup(applianceController);
    }

    @Test
    public void givenURL_whenAddAppliance_thanCheckIfBodyContainsApplianceData(){
        when(applianceService.addAppliance("Washing_Machine", "Environment_friendly", 135))
                .thenReturn("New appliance added: Appliance{id=11, item='Washing_Machine', " +
                        "description='Environment_friendly', item_value=135.0}");

        String response = RestAssured
                .given()
                .when()
                    .post("/add/appliance/Washing_Machine/Environment_friendly/135")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().body().asString();

        Assertions.assertTrue(response.contains("item='Washing_Machine', description='Environment_friendly',"));
    }
}
