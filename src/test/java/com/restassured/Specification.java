/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;


public class Specification {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeAll
    public static void initSpecs() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void firstMethod() {
        given().
            spec(requestSpec).
        when().
            get("/us/90210").
        then().
            spec(responseSpec).
        and().
            assertThat().body("places.'place name'", hasItem("Beverly Hills"));
    }

}