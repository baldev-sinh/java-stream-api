package exercise.employeemanagement;

import java.util.List;

public class AnyEmpSalaryGreaterThan100k {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    boolean b = employees.stream()
        .anyMatch(e -> e.getSalary() > 100_000);

    System.out.println("Any emp availalbe with more than 100K salary: " + b);
  }

}
