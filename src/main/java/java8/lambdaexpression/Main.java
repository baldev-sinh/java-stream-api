package java8.lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

//    Implementing Runnable
    Runnable runnable = () -> System.out.println("thread is runnin");
    new Thread(runnable).start();

//    Using with Collections
    List<String> names = Arrays.asList("Peter", "Paul", "Mary");
    names.forEach(name -> System.out.println(name));

//    Using with Custom functional interface
    MathOperation addition = (a, b) -> a + b;
    MathOperation multiplication = (a, b) -> a * b;

    System.out.println("Addition: " + addition.operate(5, 3)); // 8
    System.out.println("Multiplication: " + multiplication.operate(5, 3)); // 15

//    Using with Stream api
    List<Integer> nums = Arrays.asList(1, 3, 4, 5);
    List<Integer> squareNumbers = nums.stream()
        .map(n -> n * n)
        .collect(Collectors.toList());
    
    System.out.println(squareNumbers);

  }

}

@FunctionalInterface
interface MathOperation {

  int operate(int a, int b);
}
