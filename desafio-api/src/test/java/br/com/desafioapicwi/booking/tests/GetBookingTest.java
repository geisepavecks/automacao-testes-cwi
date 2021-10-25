package br.com.desafioapicwi.booking.tests;


import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.booking.requests.GetBookingRequest;
import br.com.desafioapicwi.runners.AllTests;
import br.com.desafioapicwi.runners.SchemaTest;
import br.com.desafioapicwi.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Listar Ids de reservas")
    public void validaListagemDeIdsDasReservas(){

        getBookingRequest.getBookingIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, SchemaTest.class})
    @DisplayName("Listar uma ID específica")
    public void validaListagemDeIdEspecifica(){

        getBookingRequest.getBookingById()
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
}