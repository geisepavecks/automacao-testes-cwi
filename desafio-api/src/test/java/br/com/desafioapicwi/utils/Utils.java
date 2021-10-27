package br.com.desafioapicwi.utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Utils {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "password123";

    public static String getSchemaBasePath(String pack, String nameSchema){
        return System.getProperty("user.dir")
                    + "/src/test/java/br/com/desafioapicwi/"
                    + pack
                    +"/schema/"
                    + nameSchema
                    + ".json";
    }

    public static int getABookingId() {
        Response bookingIds = given()
                .when()
                .get("booking");

        return bookingIds.jsonPath().getInt("[0].bookingid");
    }
}
