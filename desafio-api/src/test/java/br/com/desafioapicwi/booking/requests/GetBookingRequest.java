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
    public Response getBookingById(int id){
        return given()
                .pathParam("id", id)
                .when()
                .get("booking/{id}");

    }

    @Step("Retorna os IDs de reservas filtradas pelo firstname")
    public Response getBookingsFilteredByFirstname(String name) {
        return given()
                .queryParam("firstname", name)
                .when()
                .get("booking");
    }

    @Step("Retorna os IDs de reservas filtradas pelo lastname")
    public Response getBookingsFilteredByLastname(String name) {
        return given()
                .queryParam("lastname", name)
                .when()
                .get("booking");
    }

    @Step("Retorna os IDs de reservas filtradas pelo checkin")
    public Response getBookingsFilteredByCheckin(String checkin) {
        return given()
                .queryParam("checkin", checkin)
                .when()
                .get("booking");
    }

    @Step("Retorna os IDs de reservas filtradas pelo checkout")
    public Response getBookingsFilteredByCheckout(String checkout) {
        return given()
                .queryParam("checkout", checkout)
                .when()
                .get("booking");
    }

    @Step("Retorna os IDs de reservas filtradas pelo checkin e checkout")
    public Response getBookingsFilteredByCheckinAndCheckout(String checkin, String checkout) {
        return given()
                .queryParams("checkin", checkin, "checkout", checkout)
                .when()
                .get("booking");
    }

    @Step("Retorna os IDs de reservas filtradas pelo checkin e checkout")
    public Response getBookingsFilteredByNameCheckinAndCheckout(String firstname, String lastname, String checkin, String checkout) {
        return given()
                .queryParams(
                        "firstname", firstname,
                        "lastname", lastname,
                        "checkin", checkin,
                        "checkout", checkout)
                .when()
                .get("booking");
    }
}