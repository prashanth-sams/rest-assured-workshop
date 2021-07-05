/**
 *
 * Author: Prashanth Sams
 *
 * JsonPath, GPath, XmlPath
 *
 **/

package com.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResponseTests {

    @Test
    @DisplayName("Get method - status validation")
    void statusValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Get method - response body validation")
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
    @DisplayName("Get method - response content-type validation")
    void contentTypeValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().contentType(ContentType.JSON).
            assertThat().contentType("application/json");
    }

}
