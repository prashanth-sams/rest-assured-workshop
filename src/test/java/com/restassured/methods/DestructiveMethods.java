/**
 *
 * Author: Prashanth Sams
 *
 * POST, PATCH, PUT, DELETE
 * auth() basic() oauth2() ntlm() digest() form()
 *
 **/

package com.restassured.methods;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@Disabled
public class DestructiveMethods {

    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "ghp_3asdasdvK7MasdasasddO3lasdasddasdsQ1m9bPg";

    @Test()
    void postTest() {
        given()
            .header("Authorization", "token " + TOKEN)
            .body("{\"name\": \"deletethisrepo\"}")
        .when().
            post(BASE_URL)
        .then()
            .statusCode(201);
    }

    @Test()
    void patchTest() {
        given()
            .header("Authorization", "token " + TOKEN)
            .body("{\"name\": \"deletethisrepo-patched\"}")
        .when()
            .patch("https://api.github.com/repos/sams-pickoh/deletethisrepo")
        .then()
            .statusCode(200);
    }

    @Test()
    void deleteTest() {
        given()
            .header("Authorization", "token " + TOKEN)
        .when()
            .delete("https://api.github.com/repos/sams-pickoh/deletethisrepo-patched")
        .then()
            .statusCode(204);
    }

}
