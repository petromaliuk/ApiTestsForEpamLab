package org.example;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {

  private static final String endPoint = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void testStatusCode() {
    getRequest().assertThat().statusCode(200);
  }

  @Test
  public void testHeader() {
    getRequest().assertThat().header("content-type", equalTo("application/json; charset=utf-8"));
  }

  @Test
  public void testBody() {
    getRequest().assertThat().body("size()", equalTo(10));
  }


  private ValidatableResponse getRequest() {
    return given().when().get(endPoint).then();
  }
}
