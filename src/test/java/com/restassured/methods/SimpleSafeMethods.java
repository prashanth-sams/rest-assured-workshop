/**
 *
 * Author: Prashanth Sams
 *
 * HEAD, OPTIONS
 **/

package com.restassured.methods;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleSafeMethods {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    void headTest() {
        head(BASE_URL).
            then().
                statusCode(200).
                body(emptyOrNullString());
    }

    @Test
    void optionTest() {
        options(BASE_URL).
            then().
                statusCode(204). // NO CONTENT
                header("access-control-allow-origin", equalTo("GET, POST, PATCH, PUT, DELETE")).
                body(emptyOrNullString());
    }

}
