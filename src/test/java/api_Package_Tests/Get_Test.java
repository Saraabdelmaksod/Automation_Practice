package api_Package_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_Test {


    @Test
    public void testStatusCode(){
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().when().get("/api/users/2");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200, "Response is not 200 as expected");

    }
    @Test
    public void testQueryParam(){
        int pageNum= 2;
        RestAssured.baseURI= "https://reqres.in";
        Response response=given().queryParam("page", pageNum).when().get("/api/users");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200, "Response is not 200 as expected");
        int x = response.body().jsonPath().get("page");
        Assert.assertEquals(x, pageNum ,"The returned page not correct");

    //    String  y = response.body().jsonPath().get("data[2].email");
      //  System.out.println( "Specific Email_2 "  + y );
        Assert.assertEquals(response.body().jsonPath().get("data[2].email") , "tobias.funke@reqres.in");
        System.out.println( "All Data "  + response.body().jsonPath().get("data"));
        System.out.println( "first id "  + response.body().jsonPath().get("data.id[0]"));
    }
}
