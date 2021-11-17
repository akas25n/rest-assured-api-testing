package com.restassuredapitest.examples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestExamples {

    @Test
    public void test_01(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test_02(){

        baseURI = "https://reqres.in/api";

        given()
                .get("/users?page=2")
                .then()
                .body("data[0].id", equalTo(7));
    }
}
