package br.com.desafioapicwi.booking.requests;

import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    @Step("Criar uma nova reserva")
    public Response postBooking(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic(Utils.USERNAME, Utils.PASSWORD)
                .body(payload.toString())
                .when()
                .post("booking");
    }

    @Step("Criar uma nova reserva com o header Accept inválido")
    public Response postBookingInvalidHeader(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .accept("text/plain")
                .auth().preemptive().basic(Utils.USERNAME, Utils.PASSWORD)
                .body(payload.toString())
                .when()
                .post("booking");
    }


}
