package com.gorest.gorestinfo;


import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;


/*
 *  Created by Jay
 */
public class GorestGetTest extends TestBase {

    @Test
    public void GetListOfUser() {
        Response response = given().log().all()
                .header("page",1)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
