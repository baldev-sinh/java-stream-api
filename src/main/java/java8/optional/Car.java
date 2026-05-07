package java8.optional;

public class Car {

  private String brand;
  private String model;
  private Insurance insurance; // reference to Insurance object

  public Car(String brand, String model, Insurance insurance) {
    this.brand = brand;
    this.model = model;
    this.insurance = insurance;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public void displayCar() {
    System.out.println("Car: " + brand + " " + model);
    insurance.displayInsurance();
  }
}
