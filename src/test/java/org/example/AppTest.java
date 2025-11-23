package org.example;

import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class AppTest {

  String endPoint = "https://jsonplaceholder.typicode.com/users";

  @Test
  public void testStatusCode(){
    get().assertThat().statusCode(200);
  }

  @Test
  public void testHeader(){
    get().assertThat().header("content-type", equalTo("application/json; charset=utf-8"));
  }

  @Test
  public void testBody(){
    get().assertThat().body("size()", equalTo(10));;
  }


  public ValidatableResponse get(){
    return given().when().get(endPoint).then();
  }
}
