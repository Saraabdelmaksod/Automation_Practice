package api_Package_Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Parameters_Test {

@Test
public void testPathParameter() {
    Response activity = given().pathParam("id", 3)
            .when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}");

    System.out.println(activity.prettyPrint());
   // Assert.assertEquals(activity.body().jsonPath().get("id"), 3);
    //Rest Assert
    assertThat(activity.statusCode(), equalTo(200));
    assertThat(activity.path("title"), equalTo("Activity 3"));

}

@Test
public void testPathParameter2() {
        Response activity = given().pathParam("id", 3)
                .when().get("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
                .then().log().all().extract().response();


        JsonPath js = new JsonPath(activity.asString());

        //TestNg Assert
        Assert.assertEquals(js.getString("completed"), "false");


    }
    @Test
    public void testQueryParameter() {


    Response pageContent=given().queryParam("page", 2)
            .when().get("https://reqres.in/api/users")
            .then().log().all().extract().response();

    assertThat(pageContent.body().jsonPath().get("page"), equalTo(2));
    assertThat(pageContent.body().jsonPath().get("data.id[0]"), equalTo(7));
    assertThat(pageContent.body().jsonPath().get("data.first_name[0]"), equalTo("Michael"));

    // assert array size
    assertThat(pageContent.body().jsonPath().get("data"),hasSize(6));

    assertThat(pageContent.body().jsonPath().get("data"),hasItems("email","first_name","last_name" ));


    }
}
