package exercise.removeDuplicate.e1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Employee> employees = List.of(
        new Employee(1, "A"),
        new Employee(2, "B"),
        new Employee(1, "A"),
        new Employee(3, "C")
    );

//    1. Using Set
//    This is not Thread safe
//    Breaks with Parallel Streams
//    Has Side effects
    Set<Integer> seen = new HashSet<>();

    List<Employee> list = employees.stream()
        .filter(emp -> seen.add(emp.getId()))
        .toList();

    System.out.println(list);

//    2. Convert List to Map
    Collection<Employee> unique = employees.stream()
        .collect(Collectors.toMap(
            Employee::getId,        // key = field to deduplicate
            Function.identity(),    // value = whole object
            (existing, duplicate) -> existing  // merge strategy
        ))
        .values();

//    convert back to list
    List<Employee> result = new ArrayList<>(unique);
    System.out.println(result);
  }
}
