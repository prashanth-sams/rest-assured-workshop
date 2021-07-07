/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.serialization;

import com.restassured.serialization.pojo.BioPojo;

import static io.restassured.RestAssured.given;


public class DeSerialization {

    public static void main(String[] args) {

        String url = "https://reqres.in/api/users";

        BioPojo bio =
                given().
                    get(url).as(BioPojo.class);

        System.out.println(bio.toString());
    }

}
