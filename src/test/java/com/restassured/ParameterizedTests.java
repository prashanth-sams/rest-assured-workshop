/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured;


import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ParameterizedTests {

    @ParameterizedTest
    @MethodSource("countryDetails")
    void paramTest1(String code, String id, String country) {
        given().
        when().
            get("http://api.zippopotam.us/"+ code + "/" + id).
        then().
            assertThat().body("'country'", equalTo(country));
    }

    @ParameterizedTest
    @MethodSource("countryDetails")
    void paramTest2(String code, String id, String country) {
        given().
            pathParam("code", code).pathParam("id", id).
        when().
            get("http://api.zippopotam.us/{code}/{id}").
        then().
            assertThat().body("'country'", equalTo(country));
    }

    public static Stream<Arguments> countryDetails() {
        return Stream.of(
                Arguments.of("us", "90210", "United States"),
                Arguments.of("as", "96799", "American Samoa"),
                Arguments.of("ar", "1601", "Argentina")
        );
    }

}
