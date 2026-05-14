package exercise.employeemanagement;

import java.util.List;

public class FlattenNestedList {

  public static void main(String[] args) {
    List<Employee> employees = DummyData.dummyData();

    List<List<Employee>> list = List.of(
        employees, employees
    );

    List<Employee> list1 = list.stream()
        .flatMap(List::stream)
        .toList();

    System.out.println(list1);
  }

}
