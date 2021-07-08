/**
 *
 * Author: Prashanth Sams
 *
 * Hamcrest -> equalTo(X), hasItem(""), hasSize(2), not(equalTo(X))
 *
 **/

package com.restassured.jsonresponse;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HeaderResponseTests {

    Response response = get("https://reqres.in/api/users?page=2");

    @Test
    @DisplayName("Header response methods")
    void headerResponseMethods() {

        // get response header value
        Headers headers = response.getHeaders();
        String val = headers.getValue("server");
        System.out.println(val);

        // get headers size
        System.out.println(headers.size());

        // list all the headers
        List<Header> list = headers.asList();
        System.out.println(list);

        boolean isHeaderPresent = headers.hasHeaderWithName("server");
        System.out.println(isHeaderPresent);

    }


    @Test
    @DisplayName("Header date response validation - lambda")
    void dateResponseLambdaValidation() {
        get("https://api.github.com/users/prashanth-sams").
                then().
                header("x-ratelimit-limit", Integer::parseInt, Matchers.equalTo(60)).
                header("date", date -> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                        OrderingComparison.comparesEqualTo(LocalDate.now())).

                header("x-ratelimit-limit", response1 -> greaterThan(response1.header("x-ratelimit-remaining")));
    }


    @Test
    @DisplayName("Maps to Test Headers")
    void usingMapsToTestHeaders() {

        final Map<String,String> map = new HashMap<>();
        map.put("content-encoding", "gzip");
        map.put("access-control-allow-origin", "*");

        get("https://api.github.com/").
                then().
                headers("content-encoding", "gzip",
                        "access-control-allow-origin", "*").
                headers(map);
    }

}
