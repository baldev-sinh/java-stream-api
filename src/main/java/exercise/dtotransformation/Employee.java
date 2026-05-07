package exercise.dtotransformation;

public class Employee {

  private Long id;
  private String name;
  private String department;
  private double salary;
  private String password;


  public Employee(Long id, String name, String department, double salary, String password) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
    this.password = password;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", salary=" + salary +
        ", password='" + password + '\'' +
        '}';
  }
}
