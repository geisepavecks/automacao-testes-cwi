package br.com.desafioapicwi.booking.requests;

import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {

    @Step("Altera uma reserva pelo ID usando o token")
    public Response updateBookingWithTokenById(int id, String updateBody) {
        JSONObject credentialsBody = new JSONObject();
        credentialsBody.put("username", Utils.USERNAME);
        credentialsBody.put("password", Utils.PASSWORD);

        String tokenValue = given()
                .headers("Content-Type", "application/json")
                .body(credentialsBody.toString())
                .post("auth")
                .thenReturn().body().jsonPath().getString("token");

        return given()
                .headers("Content-Type", "application/json",
                "Cookie", "token=" + tokenValue)
                .pathParam("id", id)
                .body(updateBody)
                .when()
                .put("booking/{id}");
    }

    @Step("Altera uma reserva pelo ID usando o basic auth")
    public Response updateBookingWithBasicAuthById(int id, String updateBody) {
        return given()
                .headers("Content-Type", "application/json")
                .auth().preemptive().basic(Utils.USERNAME, Utils.PASSWORD)
                .pathParam("id", id)
                .body(updateBody)
                .when()
                .put("booking/{id}");
    }
}
