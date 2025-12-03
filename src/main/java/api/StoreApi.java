package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import models.Order;

public class StoreApi extends BaseApi {

  public static Response addOrder(Order order) {
    return given()
        .contentType("application/json")
        .body(order)
    .when()
        .post("/v2/store/order");
  }

  public static Response deleteOrder(int orderId) {
    return given()
        .pathParams("orderID", orderId)
    .when()
        .delete("/v2/store/order/{orderID}");
  }

  public static Response getOrder(int orderId) {
    return given()
        .pathParams("orderID", orderId)
    .when()
        .get("/v2/store/order/{orderID}");
  }
}
