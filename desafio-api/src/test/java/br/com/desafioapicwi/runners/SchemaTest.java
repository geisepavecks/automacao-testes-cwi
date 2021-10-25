package br.com.desafioapicwi.runners;


import br.com.desafioapicwi.booking.tests.GetBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.desafioapicwi.runners.SchemaTest.class)
@Suite.SuiteClasses({
        GetBookingTest.class

})
public class SchemaTest {
}
