package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmpByDept {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Map<String, List<Employee>> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment
        ));

    collect.forEach((dept, empList) -> {
      List<String> list = empList.stream().map(e -> e.getName()).toList();
      System.out.println(dept + " -> " + list);
    });

  }

}
