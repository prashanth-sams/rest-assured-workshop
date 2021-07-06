/**
 *
 * Author: Prashanth Sams
 *
 * XmlPath
 *
 **/

package com.restassured;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class XmlResponseTests {

    @Test
    @DisplayName("XML validation")
    void lastFromArray() {
        given().
        when().
            get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/accounts").
        then().
            assertThat().body("accounts.account[0].id", equalTo("12345")).
            assertThat().body("accounts.account[-1].id", equalTo("54321"));
//            assertThat().body("accounts.findAll{it.type!='CHECKING'}", empty());
//            assertThat().body("accounts.account[-1].@id", equalTo("54321"));  - @ is used to specify the attribute
    }

}
