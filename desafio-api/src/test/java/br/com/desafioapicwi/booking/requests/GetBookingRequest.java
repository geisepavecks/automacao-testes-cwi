package br.com.desafioapicwi.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retorna os IDs da listagem de reservas")
    public Response getBookingIds(){
        return given()
                .when()
                .get("booking");

    }

    @Step("Retorna uma reserva específica")
    public Response getBookingById(){
        Response bookingIds = this.getBookingIds();
        int bookingId = bookingIds.jsonPath().getInt("[0].bookingid");

        return given()
                .when()
                .get("booking/" + bookingId);

    }
}
