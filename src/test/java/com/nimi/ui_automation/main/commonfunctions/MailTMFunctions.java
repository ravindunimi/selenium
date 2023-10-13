package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;


public class MailTMFunctions extends TestBase {

    public static String retrieveMailTmDomain() {
        mailTmInitialization();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/domains");
        System.out.println(response.body().jsonPath().getString("'hydra:member'[0].domain"));
        return response.body().jsonPath().getString("'hydra:member'[0].domain");
    }

    public Response createMailTmAccount(String email, String password) {
        mailTmInitialization();
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("address", email);
        requestParams.put("password", password);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/accounts");
        logger.info(httpRequest.log().body());
        logger.info(response.body().prettyPrint());
        Assert.assertEquals(response.getStatusCode(),201);
        return response;
    }

    public String retrieveMailTmToken(String email, String password) throws InterruptedException {
        Thread.sleep(5000);
        mailTmInitialization();
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("address", email);
        requestParams.put("password", password);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/token");
        logger.info(httpRequest.log().body());
        logger.info(response.body().prettyPrint());
        System.out.println(response.body().jsonPath().getString("token"));
        Assert.assertEquals(response.getStatusCode(),200);
        return response.body().jsonPath().getString("token");
    }

}
