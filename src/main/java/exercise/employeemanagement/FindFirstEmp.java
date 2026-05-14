package exercise.employeemanagement;

import java.util.List;
import java.util.Optional;

public class FindFirstEmp {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Optional<Employee> it = employees.stream()
        .filter(e -> e.getDepartment().equalsIgnoreCase("hr"))
        .findFirst();

    it.ifPresent(System.out::println);
  }

}
