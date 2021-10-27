package br.com.desafioapicwi.booking.tests;

import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.requests.DeleteBookingRequest;
import br.com.desafioapicwi.booking.requests.GetBookingRequest;
import br.com.desafioapicwi.runners.AcceptanceTest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.runners.E2eTest;
import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.equalTo;

@Feature("Feature - Exclusão de reservas")
public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Excluir uma reserva com sucesso")
    public void validaExclusaoDeReserva(){
        int bookingId = Utils.getABookingId();

        deleteBookingRequest.deleteBooking(bookingId)
                .then()
                .statusCode(201).body(equalTo("Created"));

        new GetBookingRequest()
                .getBookingById(bookingId)
                .then()
                .statusCode(404);
    }
/*
*
* O objetivo deste teste é validar o status code da operação DELETE.
* Como, na API, o status code retornado é 201, o teste falhará, pois
* ele espera o status code 204 (No content).
*
*
* */
    @Test
    @Severity(SeverityLevel.MINOR)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Valida o status code retornado por uma exclusão")
    public void validaStatusCodeDeExclusao(){
        deleteBookingRequest.deleteBooking(Utils.getABookingId())
                .then()
                .statusCode(204);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Tentar excluir uma reserva que não existe")
    public void validaExclusaoDeReservaInexistente(){
        int bookingId = Utils.getABookingId();

        deleteBookingRequest.deleteBooking(bookingId)
                .then()
                .statusCode(201);

        deleteBookingRequest.deleteBooking(bookingId)
                .then()
                .statusCode(405);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Category({AllTests.class, E2eTest.class})
    @DisplayName("Tentar excluir uma reserva sem autorização")
    public void validaExclusaoDeReservaSemAutorizacao(){

        deleteBookingRequest.deleteBookingNoAuth(Utils.getABookingId())
                .then()
                .statusCode(403);
    }
}