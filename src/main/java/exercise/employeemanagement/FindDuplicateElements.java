package exercise.employeemanagement;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElements {

  public static void main(String[] args) {

    List<String> list = List.of("Alec", "Alec", "Bob", "Bob", "John");

    Set<String> collect = list.stream()
        .filter(s -> Collections.frequency(list, s) > 1)
        .collect(Collectors.toSet());

    System.out.println(collect);

//    another way
    Map<String, Long> collect1 = list.stream()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.counting()
        ))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1)
        .collect(Collectors.toMap(
            Entry::getKey,
            Entry::getValue
        ));

    System.out.println(collect1);


  }
}
