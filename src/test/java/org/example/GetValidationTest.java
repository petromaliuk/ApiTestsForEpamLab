package org.example;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetValidationTest {

  private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void testGetUsersStatusCode() {
    sendGetRequest().assertThat().statusCode(200);
  }

  @Test
  public void testGetUsersHeader() {
    sendGetRequest().assertThat().header("content-type", equalTo("application/json; charset=utf-8"));
  }

  @Test
  public void testGetUsersBody() {
    sendGetRequest().assertThat().body("size()", equalTo(10));
  }


  private ValidatableResponse sendGetRequest() {
    return given().when().get(ENDPOINT).then();
  }
}
