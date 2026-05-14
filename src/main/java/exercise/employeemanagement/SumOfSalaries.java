package exercise.employeemanagement;

import java.util.List;

public class SumOfSalaries {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    double sum = employees.stream()
        .mapToDouble(Employee::getSalary)
        .sum();

    System.out.println(sum);
  }

}
