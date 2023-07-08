package api_Package_Tests;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestAuth {

   private String token;
    @Test(priority = 0)
    public void testLoginByValidUserAndPassword()
    {
        HashMap<String ,Object> userData= new HashMap<>();
        userData.put("email" , "superman@gmail.com");
        userData.put("password" , "123456");

        Header header =new Header("Content-Type", "application/json");

        Response user= given().header(header).body(userData)
                .when()
                .post("https://apingweb.com/api/login").then().log().all().extract().response();

        Assert.assertEquals(user.statusCode(), 200, " the status code is wrong");
        Assert.assertEquals(user.body().jsonPath().get("message"), "Login success", " the Message is wrong");
        Assert.assertEquals(user.body().jsonPath().get("result.email"), "superman@gmail.com", " the Mail is wrong");

       token= user.body().jsonPath().get("token");
    }



    @Test(priority = 1)
    public void getArticles(){
        Response article= given().auth().oauth2(token).when().get("https://apingweb.com/api/articles");
        article.prettyPrint();

    }


    @Test()
    public void getUsersByUsingBasicAuth(){

        Response article= given().auth().basic("admin", "12345").when().get("https://apingweb.com/api/auth/users");
        article.prettyPrint();

    }
}
