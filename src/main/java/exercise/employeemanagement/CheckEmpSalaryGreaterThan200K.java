package exercise.employeemanagement;

import java.util.List;

public class CheckEmpSalaryGreaterThan200K {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    boolean b = employees.stream()
        .anyMatch(e -> e.getSalary() > 200_000);
    System.out.println(b);
  }

}
