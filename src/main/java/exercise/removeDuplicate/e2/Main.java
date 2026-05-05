package exercise.removeDuplicate.e2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<Order> orders = List.of(
        new Order("1", "A"),
        new Order("2", "B"),
        new Order("1", "A"),
        new Order("3", "C")
    );

    Collection<Order> values = orders.stream()
        .collect(Collectors.toMap(
            order -> new OrderKey(order.getCustomer(), order.getOrderId()),
            Function.identity(),
            (existingOrder, newOrder) -> existingOrder,
            LinkedHashMap::new    // to maintain insertion order
        ))
        .values();

    // convert back to list
    List<Order> uniqueOrders = new ArrayList<>(values);
    System.out.println(uniqueOrders);

  }

}

