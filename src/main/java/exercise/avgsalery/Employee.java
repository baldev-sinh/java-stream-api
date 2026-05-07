package exercise.avgsalery;

public class Employee {

  private String name;
  private String dept;
  private double salary;

  public Employee(String name, String dept, double salary) {
    this.name = name;
    this.dept = dept;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", dept='" + dept + '\'' +
        ", salary=" + salary +
        '}';
  }
}
