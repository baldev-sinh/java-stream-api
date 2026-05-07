package exercise.flattennested;

import java.util.List;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    basicFlatMapExample();

    flatMapWithObjects();


  }

  private static void flatMapWithObjects() {
    List<Department> departments = List.of(
        new Department("HR", List.of(
            new Employee(1, "Baldev"),
            new Employee(1, "Nikhil")
        )),
        new Department("PS", List.of(
            new Employee(1, "Shubham"),
            new Employee(1, "Yashraj")
        )),
        new Department("IT", List.of(
            new Employee(1, "Kishor"),
            new Employee(1, "Jugal")
        ))
    );

    System.out.println(departments);

//    We want employees of all depts in one common list
    Stream<Department> stream = departments.stream();
    Stream<Employee> employeeStream = stream.flatMap(dept -> dept.getEmployees().stream());
    List<Employee> list = employeeStream.toList();

    System.out.println(list);

  }

  private static void basicFlatMapExample() {
    List<List<Integer>> numbers = List.of(
        List.of(1, 2, 3),
        List.of(4, 5),
        List.of(6, 7, 8)
    );

//    1. numbers.stream() returns Stream<List<Integer>>
    Stream<List<Integer>> streamsOfList = numbers.stream();

//    2. streamsOfList.flatMap(List::stream) returns Stream<Integer>
    Stream<Integer> streamsOfInt = streamsOfList.flatMap(List::stream);

//    3. streamsOfInt.toList() returns the one common list of Integers
    List<Integer> list = streamsOfInt.toList();

    System.out.println(list);
  }

}
