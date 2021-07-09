/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseExtraction {


    @Test
    void extractResponse1() {

        String output =
                given().
                when().
                    get("http://api.zippopotam.us/us/90210").
                then().
                    extract().
                        path("places[0].'place name'");

        assertEquals(output, "Beverly Hills");
    }

    @Test
    void extractResponse2() {

        String output =
                given().
                when().
                    get("http://api.zippopotam.us/us/90210").
                then().
                    extract().
                        jsonPath().
                        getString( "places[0].'place name'" );

        assertEquals(output, "Beverly Hills");
    }


}
