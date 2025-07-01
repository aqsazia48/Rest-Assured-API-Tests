package com.example;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiTest {

    @Test
    public void testGetPost() {
        baseURI = "https://jsonplaceholder.typicode.com";

        given().
        when().
            get("/posts/1").
        then().
            statusCode(200).
            body("id", equalTo(1));
    }

    @Test
    public void testPostRequest() {
        baseURI = "https://jsonplaceholder.typicode.com";

        given().
            contentType(ContentType.JSON).
            body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }").
        when().
            post("/posts").
        then().
            statusCode(201).
            body("title", equalTo("foo"));
    }

    @Test
    public void testPostRequestResults() {
    baseURI = "https://jsonplaceholder.typicode.com";

        // Send POST request and store the response
        Response response = 
            given().
                contentType(ContentType.JSON).
                body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }").
            when().
                post("/posts");

        // Print response
        System.out.println("Response Body:");
        response.prettyPrint();

        // ✅ Assertions
        response.then().
                statusCode(201).
                body("title", equalTo("foo")).
                body("body", equalTo("bar")).
                body("userId", equalTo(1)).
                body("id", notNullValue()); // dummy API returns id = 101
    }


    @Test
    public void testUserAuth() {
        baseURI = "https://dummyjson.com";
    
        Response response = given().
            contentType(ContentType.JSON).
            body("{ \"username\": \"kminchelle\", \"password\": \"0lelplR\" }").
        when().
            post("/auth/login");  // ✅ must be this exact path
    
        response.then().
            statusCode(200).
            body("token", notNullValue());
    
        String token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);
    }
    
}
