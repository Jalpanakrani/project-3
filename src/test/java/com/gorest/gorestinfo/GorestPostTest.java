package com.gorest.gorestinfo;

import com.gorest.model.GorestPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class GorestPostTest extends TestBase {

    @Test
    public void creatUserList(){
        TestUtils.getRandomValue();
        GorestPojo gorestPojo= new GorestPojo();
        gorestPojo.setName("Tenali Ramakrishna");
        gorestPojo.setGender("female");
        gorestPojo.setEmail("tenali.ramakrishna"+TestUtils.getRandomValue()+"@gmail.com");
        gorestPojo.setStatus("active");
        Response response=given()
                .auth().oauth2("291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Accept","application/json")
                .body(gorestPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}