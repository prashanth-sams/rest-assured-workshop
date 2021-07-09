/**
 *
 * Author: Prashanth Sams
 *
 * Request Specification & Response Specification
 **/

package com.restassured.optimization;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static com.restassured.configuration.example.ConfigFactory.getDefaultConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;


public class Specification2 {

    @Test
    public void firstMethod() {
        given().
            spec(getDefaultRequestSpec()).
        when().
            get("/us/90210").
        then().
            statusCode(200);
    }

    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri("http://api.zippopotam.us").
                setConfig(getDefaultConfig()).
                build();
    }

}