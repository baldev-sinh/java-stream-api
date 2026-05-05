package exercise.highestsalary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<Employee> list = List.of(
        new Employee("Baldev", "PS", 500000),
        new Employee("Nikhil", "HR", 200000),
        new Employee("Nimesh", "Finance", 100000),
        new Employee("Rohan", "PS", 900000),
        new Employee("Arpit", "PS", 950000),
        new Employee("Kiran", "Finance", 900000)
    );

    System.out.println("Top 3 Person with highest salary");
    getTop3HighSalaryPerson(list);

    System.out.println("Top 3 highest salary");
    getTop3HighSalaryOnly(list);

    System.out.println("Top 3 highest distinct salary");
    getTop3DistinctHighSalaryOnly(list);

    System.out.println("Top 3 highest distinct salary per department");
    getTop3DistinctHighSalaryPerDepartment(list);

  }

  private static void getTop3HighSalaryPerson(List<Employee> list) {
    List<Employee> top3HighSalary = list.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .limit(3)
        .toList();

    top3HighSalary.forEach(System.out::println);
  }

  private static void getTop3HighSalaryOnly(List<Employee> list) {
    List<Double> result = list.stream()
        .map(Employee::getSalary)
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .toList();

    result.forEach(System.out::println);
  }

  private static void getTop3DistinctHighSalaryOnly(List<Employee> list) {
    List<Double> result = list.stream()
        .map(Employee::getSalary)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .toList();

    result.forEach(System.out::println);
  }

  private static void getTop3DistinctHighSalaryPerDepartment(List<Employee> empList) {
    Map<String, List<Employee>> result =
        empList.stream()
            .collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .limit(3)
                        .toList()
                )
            ));

    result.forEach((s, employees) -> {
      System.out.print(s + " -> ");
      List<String> empNames = employees.stream()
          .collect(
              Collectors.mapping(Employee::getName, Collectors.toList())
          );
      System.out.println(empNames);
    });

  }

}
