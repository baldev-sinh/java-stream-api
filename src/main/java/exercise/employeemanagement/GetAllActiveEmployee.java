package exercise.employeemanagement;

import java.util.List;

public class GetAllActiveEmployee {

  public static void main(String[] args) {

    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .filter(Employee::isActive)
        .toList()
        .forEach(e -> {
          System.out.println(e.getName() + " -> " + e.isActive());
        });

  }

}
