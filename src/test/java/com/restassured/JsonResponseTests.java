/**
 *
 * Author: Prashanth Sams
 *
 * JsonPath
 *
 **/

package com.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsonResponseTests {

    @Test
    @DisplayName("Status validation")
    void statusValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Response body validation")
    void bodyValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().body("country", equalTo("United States")).
            assertThat().body("'post code'", equalTo("90210")).
            assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    @DisplayName("Response content-type validation")
    void contentTypeValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().contentType(ContentType.JSON).
            assertThat().contentType("application/json");
    }

    @Test
    @DisplayName("Last from array validation")
    void lastFromArray() {
        given().
        when().
            get("https://reqres.in/api/users?page=2").
        then().
            assertThat().body("data[-1].id", equalTo(12));
    }

}
