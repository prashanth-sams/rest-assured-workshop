/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.serialization.pojo.BioPojo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Serialization {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        BioPojo bio = new BioPojo();

        bio.setName("Sams");
        bio.setJob("Farmer");

        String url = "https://reqres.in/api/users";

        String body = MAPPER.writeValueAsString(bio);

        Response response =
                given().
                    contentType("application/json").log().all().
                    body(body).
                    post(url).andReturn();

        assertEquals(response.statusCode(), 201, "successfully created");
    }

}
