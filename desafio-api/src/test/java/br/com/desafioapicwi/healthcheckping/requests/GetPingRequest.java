package br.com.desafioapicwi.healthcheckping.requests;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequest {

    @Step("Retorna API online")
    public Response pingReturnApi(){
        return   given()
                .header("Content-Type", "application/json")
                .when()
                .get("ping");
    }
}
