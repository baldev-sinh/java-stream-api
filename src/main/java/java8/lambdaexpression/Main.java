package java8.lambdaexpression;

import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Peter", "Paul", "Mary");
    names.forEach(name -> System.out.println(name));
  }

}
