package exercise.employeemanagement;

import java.util.List;

public class GetDistinctCities {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .map(Employee::getCity)
        .distinct()
        .toList()
        .forEach(System.out::println);
  }

}
