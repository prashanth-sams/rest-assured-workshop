/**
 *
 * Author: Prashanth Sams
 *
 * Request Specification & Response Specification
 **/

package com.restassured.configuration;


import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


@Disabled
public class URLForwarding {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void maxRedirectsTests() {

        RestAssured.config = RestAssured.config().
                                redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(0));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap").
                then().
                statusCode(equalTo(200));
    }

}