/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class QueryParamsTest {

    @BeforeAll
    public static void setup() {
        baseURI = "https://reqres.in/api/users";
    }

    @Test
    @DisplayName("Query Param")
    void queryParamTest() {
        given().
            queryParam("page", 2).
            queryParam("delay", 1).
        when().
            get().
        then().
            assertThat().body("data.id[0]", equalTo(7));
    }

    @Test
    @DisplayName("Query Params")
    void queryParamsTest1() {
        given().
            queryParams("page", 2, "delay", 1).
        when().
            get().
        then().
            assertThat().body("data.id[0]", equalTo(7));
    }

    @Test
    @DisplayName("Query Params - Mapped")
    void queryParamsTest2() {
        given().
            queryParams(getParams()).
        when().
            get().
        then().
            assertThat().body("data.id[0]", equalTo(7));
    }


    public Map<String, Integer> getParams() {
        Map<String, Integer> map =  new HashMap<>();
        map.put("page", 2);
        map.put("delay", 1);
        return map;
    }
}
