package br.com.desafioapicwi.booking.tests;


import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.requests.GetBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.runners.SchemaTest;
import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, SchemaTest.class})
    @DisplayName("Garantir o Schema de retorno de uma reserva específica")
    public void validaSchemaListagemDeIdEspecifica(){

        getBookingRequest.getBookingById(Utils.getABookingId())
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "booking"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, SchemaTest.class})
    @DisplayName("Garantir o Schema de retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas(){

        getBookingRequest.getBookingIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar Ids de reservas")
    public void validaListagemDeIdsDasReservas(){

        getBookingRequest.getBookingIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar uma reserva específica")
    public void validaListagemDeReservaEspecifica(){

        getBookingRequest.getBookingById(Utils.getABookingId())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro firstname")
    public void validaListagemDeIdsDeReservasPorFirstname(){
        String name = getBookingRequest.getBookingById(Utils.getABookingId()).
                thenReturn()
                .body()
                .jsonPath()
                .getString("firstname");

        getBookingRequest.getBookingsFilteredByFirstname(name)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro lastname")
    public void validaListagemDeIdsDeReservasPorLastname(){
        String name = getBookingRequest.getBookingById(Utils.getABookingId()).
                thenReturn()
                .body()
                .jsonPath()
                .getString("lastname");

        getBookingRequest.getBookingsFilteredByLastname(name)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin")
    public void validaListagemDeIdsDeReservasPorCheckin(){
        String checkin = getBookingRequest.getBookingById(Utils.getABookingId()).
                thenReturn()
                .body()
                .jsonPath()
                .getString("bookingdates.checkin");

        getBookingRequest.getBookingsFilteredByCheckin(checkin)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkout")
    public void validaListagemDeIdsDeReservasPorCheckout(){
        String checkout = getBookingRequest.getBookingById(Utils.getABookingId()).
                thenReturn()
                .body()
                .jsonPath()
                .getString("bookingdates.checkout");

        getBookingRequest.getBookingsFilteredByCheckout(checkout)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin e checkout")
    public void validaListagemDeIdsDeReservasPorCheckinECheckout(){
        Map<String, String> bookingdates = getBookingRequest.getBookingById(Utils.getABookingId()).
                thenReturn()
                .body()
                .jsonPath().getMap("bookingdates");

        getBookingRequest
                .getBookingsFilteredByCheckinAndCheckout(
                        bookingdates.get("checkin"),
                        bookingdates.get("checkout"))
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro name, checkin e checkout")
    public void validaListagemDeIdsDeReservasPorNameCheckinECheckout(){
        JsonPath jsonPath = getBookingRequest
                .getBookingById(Utils.getABookingId())
                .thenReturn()
                .body()
                .jsonPath();
        String firstname = jsonPath.getString("firstname");
        String lastname = jsonPath.getString("lastname");
        Map<String, String> bookingdates = jsonPath.getMap("bookingdates");



        getBookingRequest
                .getBookingsFilteredByNameCheckinAndCheckout(
                        firstname, lastname, bookingdates.get("checkin"), bookingdates.get("checkout"))
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}