package java8.sorting;

import java.util.Arrays;
import java.util.List;

public class SortingExample {

  public static void main(String[] args) {

//    Using List.sort Method
    List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Dave");

    names.sort((o1, o2) -> o1.compareTo(o2));

    System.out.println(names);

//    Using stream.sorted method
    List<String> list = names.stream()
        .sorted((o1, o2) -> o1.compareTo(o2))
        .toList();

    System.out.println(list);

  }

}
