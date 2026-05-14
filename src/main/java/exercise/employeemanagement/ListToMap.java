package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Map<Long, Employee> collect = employees.stream()
        .collect(Collectors.toMap(
            Employee::getId,
            Function.identity()
        ));

    System.out.println(collect);
  }

}
