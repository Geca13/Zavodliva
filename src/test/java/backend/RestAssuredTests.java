package backend;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTests {

    @Test
    public void assertHomePageLoads(){

        Response response = get("https://zavodlivakvecherina.herokuapp.com/");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

    }



    @Test
    public void registerTest(){

        RestAssured.baseURI ="https://zavodlivakvecherina.herokuapp.com";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "email@email.com");
        requestParams.put("password", "Password@123");
        request.body(requestParams.toJSONString());
        Response response = request.post("/");
        ResponseBody body = response.getBody();
        Assert.assertEquals(response.getStatusCode(), 302);

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());


    }
}
