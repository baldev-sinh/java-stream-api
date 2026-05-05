package exercise.removeDuplicate.e2;

public class Order {

  private String orderId;
  private String customer;

  public Order(String orderId, String customer) {
    this.orderId = orderId;
    this.customer = customer;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderId='" + orderId + '\'' +
        ", customer='" + customer + '\'' +
        '}';
  }
}
