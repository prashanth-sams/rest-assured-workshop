/**
 *
 * Author: Prashanth Sams
 *
 * URI, BASE_PATH, ROOTPATH
 *
 **/

package com.restassured.optimization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UriUrl {


    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    @DisplayName("Set Base URI & path")
    void bodyValidation1() {
        get("?page=2").
            prettyPeek().
        then().
            assertThat().body("id[0]", equalTo(7));
    }

    @Test
    @DisplayName("Set Base URI & path")
    void bodyValidation2() {
        get("?page=2").
                prettyPeek().
                then().
                assertThat().body("id[1]", equalTo(8));
    }

}
