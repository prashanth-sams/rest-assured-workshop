/**
 *
 * Author: Prashanth Sams
 *
 * JsonPath
 *
 **/

package com.restassured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class JsonPathTests {

    public static final String BASE_URL = "https://reqres.in/api/users?page=2";

    @Test
    @DisplayName("get() - Get a field value")
    void jsonPathValidation1() {

        Response response = get(BASE_URL);

        JsonPath jpath = response.body().jsonPath();

        int value1 = jpath.get("page");
        int value2 = jpath.get("data[0].id");

        System.out.println(value1 + " : " + value2);
    }

    @Test
    @DisplayName("getList() & flatten() - Get List of values from the same field in an array")
    void jsonPathValidation2() {

        Response response = get(BASE_URL);

        List list = response.body().jsonPath().getList("data.id.flatten()");
        System.out.println(list);

        List list2 = response.body().jsonPath().getList("data");
        System.out.println(list2);
    }

}
