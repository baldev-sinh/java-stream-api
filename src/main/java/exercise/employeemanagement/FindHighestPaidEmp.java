package exercise.employeemanagement;

import java.util.Comparator;
import java.util.List;

public class FindHighestPaidEmp {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Employee employee = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .toList()
        .get(0);

    System.out.println("Highest Paid Employee: " + employee);
  }

}
