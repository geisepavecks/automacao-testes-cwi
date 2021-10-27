package br.com.desafioapicwi.booking.tests;

import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.payloads.BookingPayloads;
import br.com.desafioapicwi.booking.requests.PutBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;

@Feature("Feature - Atualização de reservas")
public class PutBookingTest extends BaseTest {

    PutBookingRequest putBookingRequest = new PutBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Alterar uma reserva usando o token")
    public void validaAlteracaoDeReservaComToken() {
        JSONObject updateBody = new BookingPayloads()
                .payloadsValidBookingCreateClient();

        putBookingRequest
                .updateBookingWithTokenById(Utils.getABookingId(), updateBody.toString())
                .then()
                .statusCode(200)
                .body("", equalTo(updateBody.toMap()));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Alterar uma reserva usando o Basic auth")
    public void validaAlteracaoDeReservaComBasicAuth() {
        JSONObject updateBody = new BookingPayloads()
                .payloadsValidBookingCreateClient();

        putBookingRequest
                .updateBookingWithBasicAuthById(Utils.getABookingId(), updateBody.toString())
                .then()
                .statusCode(200)
                .body("", equalTo(updateBody.toMap()));
    }
}
