package com.restassured.configuration.example;

import com.restassured.deserialization.pojo.User;
import com.restassured.deserialization.pojo.UserList;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.restassured.configuration.example.ConfigFactory.getDefaultConfig;

public class ConfigTests {

    public static final String BASE_URL = "http://0.0.0.0:3000/users";

    @BeforeAll
    public static void setup() {
        RestAssured.config = getDefaultConfig();
    }

    @Test
    void configTests() {
        UserList user[] = RestAssured.get(BASE_URL).as(UserList[].class);

        Assertions.assertEquals(user[0].getName(), "Prashanth");
    }

}
