package com.restassuredapitest.examples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testPost(){

        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<>();

        JSONObject request = new JSONObject(map);

        request.put("name", "Akash");
        request.put("job", "Teacher");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                    .post("/users")
                .then()
                    .statusCode(201).log().all();
    }
}
