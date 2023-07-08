package api_Package_Tests;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StatusCodeTest {

    @Test
    public void okStatus(){
        Response user= given().when().get("https://reqres.in/api/users/2");

        Assert.assertEquals(user.statusCode(),200);
    }

    @Test
    public void createdStatus(){
        HashMap<String, Object> userData= new HashMap<>();
        userData.put("name", "morpheus");
        userData.put("job", "leader");

        Response user= given().body(userData).when().post("https://reqres.in/api/users");

        Assert.assertEquals(user.statusCode(),201);
    }

    @Test
    public void NotFoundStatus(){

        // Not Found when the server can't find the required resource (status ->> 404)

        Response article= given().when().get("https://reqres.in/api/unknown/23");
        Assert.assertEquals(article.statusCode(),404);


    }

    @Test
    public void BadRequestStatus(){

   /*     String body="{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        Response article= given().body(body).when().post("https://reqres.in/api/register");
        Assert.assertEquals(article.statusCode(),400);*/

        // bad Request when required data as user or password is missing (status ->> 400)

        HashMap<String ,Object> userData= new HashMap<>();
        userData.put("email" , "superman@gmail.com");


        Header header =new Header("Content-Type", "application/json");

        Response user= given().header(header).body(userData)
                .when()
                .post("https://apingweb.com/api/login").then().log().all().extract().response();

        Assert.assertEquals(user.statusCode(), 400, " the status code is wrong");

    }


    @Test
    public void unAuthorizedStatus(){
        // bad Request when required data as user or password is missing (status ->> 401)


    }
}
