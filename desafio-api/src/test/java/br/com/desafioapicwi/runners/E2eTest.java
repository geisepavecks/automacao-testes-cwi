package br.com.desafioapicwi.runners;

import br.com.desafioapicwi.booking.tests.DeleteBookingTest;
import br.com.desafioapicwi.booking.tests.GetBookingTest;
import br.com.desafioapicwi.booking.tests.PostBookingTest;
import br.com.desafioapicwi.booking.tests.PutBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.desafioapicwi.runners.E2eTest.class)
@Suite.SuiteClasses({
        DeleteBookingTest.class,
        GetBookingTest.class,
        PostBookingTest.class,
        PutBookingTest.class
})
public class E2eTest {
}
