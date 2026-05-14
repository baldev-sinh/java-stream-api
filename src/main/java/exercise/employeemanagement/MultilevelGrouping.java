package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultilevelGrouping {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();

    Map<String, Map<String, List<Employee>>> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.groupingBy(Employee::getCity)
        ));

    collect.forEach((dept, map) -> {
      System.out.print(dept + " -> ");
      map.forEach((city, emp) -> {
        List<String> list = emp.stream()
            .map(Employee::getName)
            .toList();

        System.out.print(city + " -> " + list + ", ");
      });
      System.out.println();
    });
  }

}
