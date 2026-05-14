package exercise.employeemanagement;

import java.util.List;
import java.util.stream.Collectors;

public class JoinEmpNames {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    String collect = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.joining(", "));

    System.out.println(collect);
  }

}
