/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RepeatingItemsTests {

    @Test
    void repeatingItemsValidation() {
        given().
        when().
            get("https://reqres.in/api/users?page=2").
        then().
            body("data.id", contains(7, 8, 9, 10, 11, 12)).
            body("data.id", containsInAnyOrder(12, 8, 11, 10, 7, 9)).
            body("data.id", hasItem(12)).
            body("data.email", hasItem(endsWith(".in")));
    }

}
