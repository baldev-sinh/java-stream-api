package exercise.employeemanagement;

import java.util.List;
import java.util.stream.Collectors;

public class AvgSalaryByDept {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.averagingDouble(Employee::getSalary)
        ))
        .forEach((dept, avgSalary) -> {
          System.out.println(dept + " -> " + avgSalary);
        });
  }

}
