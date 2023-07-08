package api_Package_Tests;


import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import static io.restassured.RestAssured.given;



public class Post_Test {

    @Test
    public void createUser()
    {
        String userData= "{\n" +
                "  \"id\": 0,\n" +
                "  \"userName\": \"Sara\",\n" +
                "  \"password\": \"1234567\"\n" +
                "}";

        Response user= given().header("Content-Type", "application/json").body(userData)
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users").then().log().all().extract().response();

        Assert.assertEquals(user.statusCode(), 200, " the status code is wrong");
        Assert.assertEquals(user.body().jsonPath().get("userName"), "Sara", " the Name code is wrong");


    }

    @Test
    public void createUserUsingHasMap()
    {

        // here we add dependency Jackson Databind  to convert hashmap or java object to JSON
        HashMap<String ,Object> userData= new HashMap<>();
        userData.put("id" , 3);
        userData.put("userName" , "Sara Abd");
        userData.put("password" , "1234567");

        Header header =new Header("Content-Type", "application/json");

        Response user= given().header(header).body(userData)
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users");

        Assert.assertEquals(user.statusCode(), 200, " the status code is wrong");
        Assert.assertEquals(user.body().jsonPath().get("userName"), "Sara Abd", " the Name is wrong");

    }

    @Test
    public void UserCreationUsingJSONObject()
    {

        // here we add dependency JSON In Java
        JSONObject userData= new JSONObject();
        userData.put("id", 4);
        userData.put("userName" , "Sara AbdElMaksoud");
        userData.put("password" , "1234567");

        Header header =new Header("Content-Type", "application/json");

        // add toString()
        Response user= given().header(header).body(userData.toString())
                .when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Users");

        Assert.assertEquals(user.statusCode(), 200, " the status code is wrong");
        Assert.assertEquals(user.body().jsonPath().get("userName"), "Sara AbdElMaksoud", " the Name is wrong");

    }

@Test
    public void readUserDataByFile(){
    Header header =new Header("Content-Type", "application/json");

    File data= new File("src\\main\\resources\\testData");

    given().header(header).body(data)
            .when().put("https://reqres.in/api/users/2")
            .then().log().all().assertThat().statusCode(200);



}
}
