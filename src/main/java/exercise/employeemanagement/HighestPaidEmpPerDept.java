package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestPaidEmpPerDept {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();

    Map<String, Optional<Employee>> collect1 = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ));

    Map<String, Employee> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                Optional::get
            )
        ));

    collect.forEach((dept, employee) -> {
      System.out.println(dept + " -> " + employee.getName()
          + " Salary: " + employee.getSalary()
      );
    });


  }

}
