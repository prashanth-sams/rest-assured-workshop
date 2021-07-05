/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Logs {

    @Test
    @DisplayName("Log all - request")
    void logRequest() {
        given().
            log().all().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Log all - response")
    void logResponse() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
        log().all();
    }

    @Test
    @DisplayName("Log body")
    void logBody() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
        log().body();
    }
}
