package exercise.flattennested;

import java.util.List;

public class Department {

  private String deptName;

  public Department(String deptName, List<Employee> employees) {
    this.deptName = deptName;
    this.employees = employees;
  }

  private List<Employee> employees;


  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  @Override
  public String toString() {
    return "Department{" +
        "deptName='" + deptName + '\'' +
        ", employees=" + employees +
        '}';
  }
}
