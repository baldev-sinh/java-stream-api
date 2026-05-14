package exercise.employeemanagement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCountOfElements {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();
    Map<String, Long> collect = employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.counting()
        ));

    collect.forEach((s, aLong) -> {
      System.out.println(s + " -> " + aLong);
    });
  }

}
