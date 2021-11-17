package com.restassuredapitest.examples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetAndPostExamples {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api";

        given()
                .get("/users?page=2")
                .then()
                .body("data.first_name", hasItem("Lindsay"))
                .body("data[2].first_name", equalTo("Tobias"));
    }
}
