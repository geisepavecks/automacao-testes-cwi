package br.com.desafioapicwi.booking.requests;

import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    @Step("Deleta uma reserva específica")
    public Response deleteBooking(int id){

        return given()
                .auth().preemptive().basic(Utils.USERNAME, Utils.PASSWORD)
                .pathParam("id", id)
                .when()
                .delete("booking/{id}");
    }

    @Step("Deleta uma reserva específica sem autorização")
    public Response deleteBookingNoAuth(int id){

        return given()
                .pathParam("id", id)
                .when()
                .delete("booking/{id}");
    }
}