package exercise.employeemanagement;

class Employee {

  private Long id;
  private String name;
  private String department;
  private double salary;
  private int age;
  private String city;
  private boolean active;

  public Employee(Long id, String name, String department, double salary, int age, String city,
      boolean active) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
    this.age = age;
    this.city = city;
    this.active = active;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", department='" + department + '\'' +
        ", salary=" + salary +
        ", age=" + age +
        ", city='" + city + '\'' +
        ", active=" + active +
        '}';
  }
}
