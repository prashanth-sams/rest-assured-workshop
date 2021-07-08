/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MatcherTests {

    @Test
    @DisplayName("Response body validation")
    void bodyValidation() {
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().body("country", containsString("United"));
    }

    @Test
    @DisplayName("Any Key / Value Matcher - without AssertThat")
    void bodyMatcher() {
        given().
                when().
                    get("https://reqres.in/api/users?page=2").
                then().
                    body("page", equalTo(2)).
                    body(containsString("id")).
                    body(containsString("page"), containsString("per_page"));
    }

    @Test
    @DisplayName("Matcher Lambda fn - without AssertThat")
    void lambdaBodyMatcher() {
        given().
            get("https://reqres.in/api/users?page=2").
        then().
            body("data[0].email", response -> containsString("michael")).
            body("data[0].email", response -> containsString(response.body().jsonPath().get("data[0].email")));
    }

}
