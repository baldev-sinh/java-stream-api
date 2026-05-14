package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Top2HighestPaidEmpPerDept {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();

    Map<String, List<String>> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.collectingAndThen(
                Collectors.toList(),
                empList -> empList.stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .limit(2)
                    .map(e -> e.getName() + "(" + e.getSalary() + ")")
                    .toList()
            )
        ));

    collect.forEach((dept, emps) -> {
      System.out.println(dept + " -> " + emps);
    });


  }

}
