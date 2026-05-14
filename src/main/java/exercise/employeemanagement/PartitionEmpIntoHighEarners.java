package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEmpIntoHighEarners {

  public static void main(String[] args) {

    List<Employee> employees = DummyData.dummyData();
    Map<Boolean, List<Employee>> collect = employees.stream()
        .collect(Collectors.partitioningBy(
            e -> e.getSalary() > 50_000
        ));

    collect.forEach((high, emp) -> {

      List<String> list = emp.stream()
          .map(Employee::getName)
          .toList();
      System.out.println(high + " -> " + list);
    });

  }

}
