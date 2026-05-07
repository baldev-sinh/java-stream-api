package java8.optional;

public class Person {

  private String name;
  private Car car;

  public Person(String name, Car car) {
    this.name = name;
    this.car = car;
  }

  public void displayPerson() {
    System.out.println("Person: " + name);
    car.displayCar();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }
}
