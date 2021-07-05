/**
 *
 * Author: Prashanth Sams
 *
 * Hamcrest -> equalTo(X), hasItem(""), hasSize(2), not(equalTo(X))
 *
 **/

package com.restassured;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HamcrestTests {

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
            assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

}
