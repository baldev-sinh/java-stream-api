package exercise.highestsalary;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<Employee> list = List.of(
        new Employee("Baldev", "PS", 85000),
        new Employee("Nikhil", "HR", 51000),
        new Employee("Yashraj", "HR", 50000),
        new Employee("Shubham", "HR", 51000),
        new Employee("Nimesh", "Finance", 10000),
        new Employee("Rohan", "PS", 90000),
        new Employee("Arpit", "PS", 95000),
        new Employee("Kiran", "Finance", 90000)
    );

    System.out.println("Top 3 Person with highest salary");
    getTop3HighSalaryPerson(list);

    System.out.println("Top 3 highest salary");
    getTop3HighSalaryOnly(list);

    System.out.println("Top 3 highest distinct salary");
    getTop3DistinctHighSalaryOnly(list);

    System.out.println("Top 3 highest salary per department");
    getTop3HighSalaryPerDepartment(list);

    System.out.println("Top 3 distinct highest salary per department");
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

  private static void getTop3HighSalaryPerDepartment(List<Employee> empList) {

    Map<String, List<String>> result = empList.stream()
        .filter(employee -> employee.getSalary() > 50000)
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .limit(3)
                    .map(Employee::getName)
                    .toList()
            )
        ));

    result.forEach((dept, names) -> {
      System.out.println(dept + " -> " + names);
    });
  }

  private static void getTop3DistinctHighSalaryPerDepartment(List<Employee> empList) {

    Map<String, List<String>> collect = empList.stream()
        .filter(emp -> emp.getSalary() > 50000)
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .collect(
                        Collectors.toMap(
                            Employee::getSalary,
                            Employee::getName,
                            (existing, duplicate) -> existing,
                            LinkedHashMap::new
                        )
                    )
                    .values()
                    .stream()
                    .limit(3)
                    .toList()
            )
        ));

    collect.forEach((dept, distinctNames) -> {
      System.out.println(dept + " -> " + distinctNames);
    });

  }


}
