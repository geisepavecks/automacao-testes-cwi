package br.com.desafioapicwi.booking.tests;

import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.payloads.BookingPayloads;
import br.com.desafioapicwi.booking.requests.PostBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.runners.E2eTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Feature - Criação de reservas")
public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Criar uma nova reserva")
    public void validaCriacaoDeReserva(){

        postBookingRequest.postBooking(new BookingPayloads().payloadsValidBookingCreateClient())
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Validar retorno 500 quando o payload da reserva estiver inválido")
    public void validaCriacaoDeReservaInvalida(){

        postBookingRequest.postBooking(new BookingPayloads().payloadsInvalidBookingCreateClient())
                .then()
                .statusCode(500);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Validar a criação de mais de uma reserva em sequencia")
    public void validaCriacaoDeReservaSequencial(){
        BookingPayloads bookingPayloads = new BookingPayloads();

        for(int i = 0; i < 5; i++) {
            postBookingRequest.postBooking(bookingPayloads.payloadsValidBookingCreateClient())
                    .then()
                    .statusCode(200)
                    .body("bookingid", notNullValue());
        }
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")
    public void validaCriacaoDeReservaComParametrosExtras(){

        postBookingRequest.postBooking(new BookingPayloads().payloadsBookingCreateClientExtraParams())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Validar retorno 418 quando o header Accept for invalido")
    public void validaCriacaoDeReservaComHeaderInvalido(){

        postBookingRequest.postBookingInvalidHeader(new BookingPayloads().payloadsBookingCreateClientExtraParams())
                .then()
                .statusCode(418);
    }
}