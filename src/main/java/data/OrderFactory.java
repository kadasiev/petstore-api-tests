package data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import models.Order;

public class OrderFactory {

  public static Order newOrder() {
    Order order = new Order();
    order.setId(new Random().nextInt(10) + 1);
    order.setPetId(new Random().nextInt(1000) + 1);
    order.setQuantity(1);
    order.setShipDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
    order.setStatus("placed");
    order.setComplete(true);
    return order;
  }
}
