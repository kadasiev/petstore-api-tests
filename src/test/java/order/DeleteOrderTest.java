package order;

import static api.StoreApi.addOrder;
import static api.StoreApi.deleteOrder;
import static api.StoreApi.getOrder;
import static data.OrderFactory.newOrder;

import models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteOrderTest {

  private Order order;

  @BeforeEach
  public void setUp() {
    order = newOrder();
    addOrder(order).then()
        .statusCode(200);
  }

  @Test
  public void shouldRemoveTheOrderWhenExistingIdProvided() {
    deleteOrder(order.getId())
        .then()
        .statusCode(200);

    getOrder(order.getId()).then()
        .statusCode(404);
  }
}
