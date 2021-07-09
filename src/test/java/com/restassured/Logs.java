/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured;

import com.restassured.configuration.example.StatusCode;
import io.restassured.filter.log.LogDetail;
import org.apache.http.HttpStatus;
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
            assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Log all - response")
    void logResponse() {
        given().when().get("http://api.zippopotam.us/us/90210").
        then().
            log().all();
    }

    @Test
    @DisplayName("Log body")
    void logBody() {
        given().when().get("http://api.zippopotam.us/us/90210").
        then().
            log().body().
            log().headers().
            log().status();
    }

    @Test
    @DisplayName("Log with condition")
    void logWithCondition() {
        given().when().get("http://api.zippopotam.us/us/90210").
        then().
            log().ifStatusCodeIsEqualTo(StatusCode.OK);

        given().when().get("http://api.zippopotam.us/us/9010").
        then().
            log().ifError().
            log().ifValidationFails(LogDetail.HEADERS);
    }
}
