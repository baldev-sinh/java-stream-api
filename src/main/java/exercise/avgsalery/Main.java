package exercise.avgsalery;

import exercise.highestsalary.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<exercise.highestsalary.Employee> list = List.of(
        new Employee("Baldev", "PS", 85000),
        new Employee("Nikhil", "HR", 51000),
        new Employee("Yashraj", "HR", 50000),
        new Employee("Shubham", "HR", 51000),
        new Employee("Nimesh", "Finance", 10000),
        new Employee("Rohan", "PS", 90000),
        new Employee("Arpit", "PS", 95000),
        new Employee("Kiran", "Finance", 90000)
    );

//    1. get emp names for each dept
    System.out.println("Employee names from each dept");
    list.stream()
        .collect(Collectors.groupingBy(Employee::getDept))
        .forEach((s, employees) -> {
          System.out.print(s + "->");
          List<String> list1 = employees.stream()
              .map(Employee::getName)
              .toList();
          System.out.println(list1);
        });

//    2. get avg salary of each dept
    System.out.println("Average salary from each dept");
    Map<String, Double> collect = list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.averagingDouble(Employee::getSalary)
        ));

    collect.forEach((dept, average) -> System.out.println(dept + "->" + average));

//    3. count employee from each dept
    System.out.println("Employee count per dept");
    Map<String, Long> counting = list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.counting()
        ));
    counting.forEach((dept, count) -> {
      System.out.println(dept + "->" + count);
    });

//    4. Highest salary per dept
    System.out.println("Highest salary per dept");
    list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ))
        .forEach((dept, employee) -> {
          System.out.print(dept + "->");
          Double salary = employee.stream()
              .map(Employee::getSalary)
              .toList()
              .get(0);
          System.out.println(salary);
        });

//    5. Total salary expense per department
    System.out.println("Total salary expense per department");
    list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.summingDouble(Employee::getSalary)
        ))
        .forEach((s, aDouble) -> {
          System.out.println(s + " -> " + aDouble);
        });

//  6. Names of employees per department
    System.out.println("Names of employees per department");
    list.stream()
        .collect(Collectors.groupingBy(
            Employee::getDept,
            Collectors.mapping(Employee::getName, Collectors.toList())
        ))
        .forEach((s, strings) -> {
          System.out.println(s + " - > " + strings);
        });

    //  7. Partition employees into high earners
    System.out.println("Partition employees into high earners");
    Map<Boolean, List<Employee>> collect1 = list.stream()
        .collect(Collectors.partitioningBy(
                employee -> employee.getSalary() > 50000
            )
        );

  }

}
