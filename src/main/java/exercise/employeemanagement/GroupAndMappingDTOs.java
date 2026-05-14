package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAndMappingDTOs {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Map<String, List<String>> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.mapping(
                Employee::getName,
                Collectors.toList()
            )
        ));

    collect.forEach((s, strings) -> {
      System.out.println(s + " -> " + strings);
    });

  }

}
