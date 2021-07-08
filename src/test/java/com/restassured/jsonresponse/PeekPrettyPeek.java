/**
 *
 * Author: Prashanth Sams
 *
 **/

package com.restassured.jsonresponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PeekPrettyPeek {

    public static final String BASE_URL = "http://localhost:3000/users";

    @Test
    @DisplayName("PEEK")
    void peekMethod() {
        given().get(BASE_URL).
        peek();
    }

    @Test
    @DisplayName("PRETTY PEEK")
    void prettyPeekMethod() {
        given().get(BASE_URL).
                prettyPeek();
    }

    @Test
    @DisplayName("PRINT")
    void printMethod() {
        given().get(BASE_URL).
                print();
    }

    @Test
    @DisplayName("PRETTY PRINT")
    void prettyPrintMethod() {
        given().get(BASE_URL).
                prettyPrint();
    }

}
