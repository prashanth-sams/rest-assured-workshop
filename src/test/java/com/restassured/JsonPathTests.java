/**
 *
 * Author: Prashanth Sams
 *
 * JsonPath
 *
 **/

package com.restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class JsonPathTests {

    public static final String BASE_URL = "https://reqres.in/api/users?page=2";

    @Test
    @DisplayName("get() - Get a field value - type #1")
    void jsonPathValidation1() {

        Response response = get(BASE_URL);

        JsonPath jPath = response.body().jsonPath();

        int value1 = jPath.get("page");
        int value2 = jPath.get("data[0].id");

        System.out.println(value1 + " : " + value2);
    }

    @Test
    @DisplayName("get() - Get a field value - type #2")
    void jsonPathValidation2() {

        Response response = get(BASE_URL);

        ResponseBody<?> body = response.body();
        JsonPath jPath = body.jsonPath();

        int value1 = jPath.get("page");
        System.out.println(value1);
    }

    @Test
    @DisplayName("get() - Get whole response")
    void jsonPathValidation3() {

        Response response = get(BASE_URL);

        JsonPath jPath = response.body().jsonPath();

        // 1
        Map<String, String> fullJson = jPath.get();
        System.out.println(fullJson);

        // 2
        Map<String, String> subMap = jPath.get("data[0]");
        System.out.println(subMap);

        // 3
        // Map<String, String> subMap2 = jPath.get("data[0].xyz");
        // System.out.println(subMap2);
    }

    @Test
    @DisplayName("getList() & flatten() - Get List of values from the same field in an array")
    void jsonPathValidation4() {

        Response response = get(BASE_URL);

        List list = response.body().jsonPath().getList("data.id.flatten()");
        System.out.println(list);

        List list2 = response.body().jsonPath().getList("data");
        System.out.println(list2);
    }

    @Test
    @DisplayName("get() - Null pointer exception")
    void jsonPathValidation5() {

        Response response = get(BASE_URL);

        JsonPath jPath = response.body().jsonPath();

        Map<String, String> isNull = jPath.get("incorrect.path"); // NPE!
        System.out.println(isNull);
    }

}
