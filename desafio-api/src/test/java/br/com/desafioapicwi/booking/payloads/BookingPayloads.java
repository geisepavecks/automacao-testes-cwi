package br.com.desafioapicwi.booking.payloads;

import com.github.javafaker.Faker;
import org.json.JSONObject;

public class BookingPayloads {

    public JSONObject payloadsValidBookingCreateClient(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        Faker javaFaker = new Faker();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2018-01-01");

        payload.put("firstname", javaFaker.funnyName().name());
        payload.put("lastname", javaFaker.artist().name());
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","breakfast");

        return payload;

    }
}
