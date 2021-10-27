package br.com.desafioapicwi.runners;

import br.com.desafioapicwi.healthcheckping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.desafioapicwi.runners.HealthcheckTest.class)
@Suite.SuiteClasses({
        GetPingTest.class

})
public class HealthcheckTest {
}
