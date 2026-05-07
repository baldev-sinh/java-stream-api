package java8.optional;

public class Insurance {

  private String name;

  public Insurance(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void displayInsurance() {
    System.out.println("Insurance: " + name);
  }
}