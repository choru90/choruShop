package com.example.chorushop.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

    public static RequestSpecification request(){
        return RestAssured.given().contentType("application/json");
    }
}
