/**
 *
 * Author: Prashanth Sams
 *
 * HEAD, OPTIONS, GET, TRACE
 **/

package com.restassured.methods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Alternate to GET method")
    void getTest() {
        request(Method.GET, BASE_URL).
            then().
                statusCode(200);
    }

    @Test
    void traceTest() {
        request(Method.TRACE, BASE_URL).
            then().
                statusCode(405); // Method Not Allowed
    }

}
