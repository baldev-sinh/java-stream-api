package exercise.employeemanagement;

import java.util.List;

public class ConvertToUpperAndSort {

  public static void main(String[] args) {

    List<String> list = List.of("Zoy", "Will", "Alec", "Alec", "Bob", "Bob", "John");

    List<String> list1 = list.stream()
        .map(String::toUpperCase)
        .sorted()
        .toList();

    System.out.println(list1);

  }
}
