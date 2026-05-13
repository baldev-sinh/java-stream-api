package exercise.employeemanagement;

import java.util.List;
import java.util.stream.Collectors;

public class CountEmpByDept {

  public static void main(String[] args) {

    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.counting()
        ))
        .forEach((dept, count) -> {
          System.out.println(dept + "->" + count);
        });

  }

}
