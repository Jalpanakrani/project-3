package com.gorest.gorestinfo;


import com.gorest.model.GorestPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay vaghani
 */
public class GorestPatchTest extends TestBase {
    @Test
    public void updateUser() {

        GorestPojo gorestPojo= new GorestPojo();
        gorestPojo.setName("Allasani Peddana");
        gorestPojo.setEmail("allasani.peddana57@gmail.com");
        gorestPojo.setStatus("active");


        Response response = given()

                .auth().oauth2("291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Accept", "application/json")

                .body(gorestPojo)
                .patch("/users/2677");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

