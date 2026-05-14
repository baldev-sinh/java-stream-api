package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;

public class GetSecondHighestSalary {

  public static void main(String[] args) {

    List<Employee> employees = DummyData.dummyData();
    Double first = employees.stream()
        .map(Employee::getSalary)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .orElse(-1.0);

    System.out.println(first);
  }

}
