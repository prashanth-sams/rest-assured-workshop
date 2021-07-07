/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.deserialization.pojo.User;
import com.restassured.deserialization.pojo.UserList;
import com.restassured.serialization.pojo.BioPojo;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class DeSerialization {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {

        String url = "http://localhost:3000/users";

        Type type = new TypeReference<List<UserList>>() {}.getType();

        // 1
        List<User> user = get(url).as(type);
        System.out.println(user.toString());

        // 2
        List<UserList> ul = get(url).as(type);
        System.out.println(ul.toString());

        // 3
        UserList ul2[] = get(url).as(UserList[].class);
        System.out.println(Arrays.stream(ul2).findFirst());

        // 4
        String url2 = "https://reqres.in/api/users";
        BioPojo bio =
                given().
                        get(url2).as(BioPojo.class);
        System.out.println(bio.toString());

    }

}
