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

public class NestedBodyTests {

    @Test
    void nestedBodyValidation() {
        given().
        when().
            get("https://reqres.in/api/users?page=2").
        then().
            rootPath("data[0]").
                body("id", equalTo(7)).
                body("id", lessThanOrEqualTo(7)).
                body("first_name", notNullValue()).
            rootPath("data[-1]").
                body("id", equalTo(12));
    }

}
