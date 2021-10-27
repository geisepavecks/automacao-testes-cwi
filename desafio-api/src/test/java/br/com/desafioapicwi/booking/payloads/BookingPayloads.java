package br.com.desafioapicwi.booking.payloads;

import com.github.javafaker.Faker;
import org.json.JSONObject;

public class BookingPayloads {

    public JSONObject payloadsValidBookingCreateClient(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        Faker javaFaker = new Faker();

        bookingDates.put("checkin", "2021-10-26");
        bookingDates.put("checkout", "2021-10-28");

        payload.put("firstname", javaFaker.funnyName().name());
        payload.put("lastname", javaFaker.artist().name());
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","breakfast");

        return payload;

    }

    public JSONObject payloadsInvalidBookingCreateClient() {
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "janeiro");
        bookingDates.put("checkout", "dezembro");

        payload.put("firstname", "Invalido");
        payload.put("lastname", 0.07);
        payload.put("totalprice", "zero");
        payload.put("depositpaid", "sim");
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", 70);

        return payload;
    }

    public JSONObject payloadsBookingCreateClientExtraParams() {
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2021-10-26");
        bookingDates.put("checkout", "2021-10-28");

        payload.put("firstname", "Britney");
        payload.put("lastname", "Spears");
        payload.put("title", "Ms.");
        payload.put("totalprice", 10);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "freedom");
        payload.put("vip", true);
        payload.put("deluxe", true);
        payload.put("premium", true);

        return payload;
    }
}
