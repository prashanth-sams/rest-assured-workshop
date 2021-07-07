package com.restassured.deserialization;

import com.restassured.deserialization.pojo.UserList;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MarshallingTest {

    public static final String BASE_URL = "http://0.0.0.0:3000/users";

    @Test
    void getUsersTest() {
        UserList user[] = RestAssured.get(BASE_URL).as(UserList[].class);

        Assertions.assertEquals(user[0].getName(), "Prashanth");
    }
}