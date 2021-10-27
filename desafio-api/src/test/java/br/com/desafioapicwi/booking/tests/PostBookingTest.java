package br.com.desafioapicwi.booking.tests;

import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.payloads.BookingPayloads;
import br.com.desafioapicwi.booking.requests.PostBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
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
}
