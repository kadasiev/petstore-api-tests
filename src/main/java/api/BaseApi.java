package api;

import io.restassured.RestAssured;

public class BaseApi {

  static {
    RestAssured.baseURI = "https://petstore.swagger.io";
  }
}
