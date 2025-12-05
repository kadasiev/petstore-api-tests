package order;

import static api.StoreApi.addOrder;
import static api.StoreApi.deleteOrder;
import static api.StoreApi.getOrder;
import static data.OrderFactory.newOrder;
import static org.hamcrest.Matchers.equalTo;

import models.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindOrderTest {

  private Order order;

  @BeforeEach
  public void setUp() {
    order = newOrder();
    addOrder(order).then()
        .statusCode(200);
  }

  @AfterEach
  public void tearDown() {
    try {
      deleteOrder(order.getId());
    } catch (Exception ignored) {
    }
  }

  @Test
  public void shouldFindTheOrderWhenExistingIdProvided() {
    getOrder(order.getId()).then()
        .statusCode(200)
        .body("id", equalTo(order.getId()))
        .body("petId", equalTo(order.getPetId()));
  }
}
