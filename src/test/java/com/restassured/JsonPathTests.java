/**
 *
 * Author: Prashanth Sams
 *
 * JsonPath
 *
 **/

package com.restassured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JsonPathTests {

    @Test
    @DisplayName("Status validation")
    void statusValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }

}
