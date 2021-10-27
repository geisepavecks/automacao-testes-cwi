package br.com.desafioapicwi.booking.tests;

import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.payloads.BookingPayloads;
import br.com.desafioapicwi.booking.requests.PutBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.runners.E2eTest;
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

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Tentar alterar uma reserva quando o token não for enviado")
    public void validaAlteracaoDeReservaSemEnviarToken() {
        JSONObject updateBody = new BookingPayloads()
                .payloadsValidBookingCreateClient();

        putBookingRequest
                .updateBookingWithoutTokenById(Utils.getABookingId(), updateBody.toString())
                .then()
                .statusCode(403);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Tentar alterar uma reserva quando o token enviado for inválido")
    public void validaAlteracaoDeReservaComTokenInvalido() {
        JSONObject updateBody = new BookingPayloads()
                .payloadsValidBookingCreateClient();

        putBookingRequest
                .updateBookingWithInvalidTokenById(Utils.getABookingId(), updateBody.toString())
                .then()
                .statusCode(403);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Tentar alterar uma reserva que não existe")
    public void validaAlteracaoDeReservaInexistente() {
        JSONObject updateBody = new BookingPayloads()
                .payloadsValidBookingCreateClient();

        putBookingRequest
                .updateBookingWithBasicAuthById(-1, updateBody.toString())
                .then()
                .statusCode(405);
    }
}
