/**
 *
 * Author: Prashanth Sams
 *
 * Request Specification & Response Specification
 **/

package com.restassured.configuration;


import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


@Disabled
public class FailureListenersTests {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void maxRedirectsTests() {

        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                System.out.printf("Custom Failure! response status: %s \n with body: %s",
                        response.statusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config().failureConfig(FailureConfig.failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/prashanth-sams").
                then().
                statusCode(equalTo(200));
    }

}