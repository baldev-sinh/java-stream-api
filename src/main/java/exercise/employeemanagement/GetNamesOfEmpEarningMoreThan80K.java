package exercise.employeemanagement;

import java.util.List;

public class GetNamesOfEmpEarningMoreThan80K {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    employees.stream()
        .filter(e -> e.getSalary() > 80_000)
        .toList()
        .forEach(e -> {
          System.out.println(e.getName() + " -> " + e.getSalary());
        });
  }

}
