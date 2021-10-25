package br.com.desafioapicwi.healthcheckping.tests;


import br.com.desafioapicwi.base.BaseTest;
import br.com.desafioapicwi.healthcheckping.requests.GetPingRequest;
import br.com.desafioapicwi.runners.AllTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.lessThan;

@Feature("Feature - API online")
public class GetPingTest extends BaseTest {

    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Verifica se a API está online")
    public void validaApiOnline(){

        getPingRequest.pingReturnApi()
                .then()
                .statusCode(201)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }
}
