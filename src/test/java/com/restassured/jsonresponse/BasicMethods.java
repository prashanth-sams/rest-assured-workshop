/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicMethods {

    public static final String BASE_URL = "https://reqres.in/api/users?page=2";

    Response response = get("https://reqres.in/api/users?page=2");


    @Test
    @DisplayName("Hamcrest assertions")
    void bodyValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().body("places.'place name'", hasItem("Beverly Hills")).
            assertThat().body("places.'place name'", not(hasItem("Beverly Hi"))).
            assertThat().body("places.'place name'", hasSize(1)).
            assertThat().body("places[0].'place name'", equalTo("Beverly Hills")).
            assertThat().body("places[0].'place name'", containsStringIgnoringCase("BEVERLY Hills")).
            assertThat().body("places[0].'place name'", notNullValue()).
            assertThat().body("places[0].'place name'", not(emptyString())).
            assertThat().body("'post code'", anyOf(equalTo("90210"), equalTo("90211")));
    }

    @Test
    @DisplayName("Basic response methods")
    void basicResponseMethods() {
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
        assertEquals(response.getHeader("server"), "cloudflare");
        assertEquals(response.header("server"), "cloudflare");
    }

    @Test
    @DisplayName("Response time methods")
    void timeResponseMethods() {
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));

        get(BASE_URL).
        then().
            time(lessThan(2L), TimeUnit.SECONDS);
    }

}
