package exercise.grouping;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    Employee e1 = new Employee("Baldev", "PS");
    Employee e2 = new Employee("Nikhil", "PS");
    Employee e3 = new Employee("Nimesh", "Solution");
    Employee e4 = new Employee("Shubham", "PS");
    Employee e5 = new Employee("Vinayak", "CD");

    List<Employee> list = List.of(e1, e2, e3, e4, e5);

    grouping(list);
    concurrentGrouping(list);
    count(list);
    getOnlyEmpNames(list);
  }

  // group by department
  private static void concurrentGrouping(List<Employee> list) {
    ConcurrentMap<String, List<Employee>> concurrentGrouping = list.parallelStream()
        .collect(Collectors.groupingByConcurrent(Employee::getDepartment));
    System.out.println("Thread safe");

    concurrentGrouping.forEach((s, employees) -> {
      System.out.println(s + " -> " + employees);
    });
  }

  //  group by department
  private static void grouping(List<Employee> list) {
    Map<String, List<Employee>> grouping = list.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));

    System.out.println("Non Thread safe");
    grouping.forEach((s, employees) -> {
      System.out.println(s + " -> " + employees);
    });
  }

  //  count employees per department
  private static void count(List<Employee> list) {
    Map<String, Long> counting = list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.counting()
        ));

    System.out.println("Employees per Department");
    counting.forEach((dep, count) -> {
      System.out.println(dep + " : " + count);
    });
  }

  //  get only employees names per department
  private static void getOnlyEmpNames(List<Employee> list) {
    Map<String, List<String>> map = list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.mapping(Employee::getName, Collectors.toList())
        ));

    System.out.println("Employees Names per Department");
    map.forEach((dep, names) -> {
      System.out.println(dep + " : " + names);
    });
  }
}
