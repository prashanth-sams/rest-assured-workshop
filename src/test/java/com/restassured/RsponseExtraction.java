/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class RsponseExtraction {


    @Test
    void extractResponse() {

        String output =
                given().
                when().
                    get("http://api.zippopotam.us/us/90210").
                then().
                    extract().
                    path("places[0].'place name'");

        assertEquals(output, "Beverly Hills");
    }


}
