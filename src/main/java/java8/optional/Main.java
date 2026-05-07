package java8.optional;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {

    Optional<String> baldev = Optional.of("Baldev");
    baldev.ifPresent(System.out::println);

  }

  //  Without Optional
  public String getInsuranceName1(Person person) {
    if (person != null) {
      Car car = person.getCar();
      if (car != null) {
        Insurance insurance = car.getInsurance();
        if (insurance != null) {
          return insurance.getName();
        }
      }
    }
    return "Unknown";
  }

  //  With Optional
  public String getInsuranceName2(Person person) {
    return Optional.ofNullable(person)
        .map(Person::getCar)
        .map(Car::getInsurance)
        .map(Insurance::getName)
        .orElse("Unknown");
  }

}
