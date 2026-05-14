package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestPaidEmpPerDeptWithCustomCollectorLogic {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();

    Map<String, Employee> collect = employees.stream()
        .collect(Collectors.toMap(
            Employee::getDepartment,
            Function.identity(),
            BinaryOperator.maxBy(
                Comparator.comparing(Employee::getSalary)
            )
        ));

    collect.forEach((s, employee) -> {
      System.out.println(s + " -> " + employee.getName() + " -> " + employee.getSalary());
    });

  }

}
