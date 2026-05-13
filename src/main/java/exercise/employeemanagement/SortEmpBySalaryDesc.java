package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;

public class SortEmpBySalaryDesc {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .toList()
        .forEach(System.out::println);
  }

}
