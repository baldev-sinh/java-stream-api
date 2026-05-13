package java8.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamsExample {

  public static void main(String[] args) throws Exception {

    // Create a list of integers from 1 to 10
    List<Integer> numbers = Arrays.asList(
        1, 2, 3, 4, 5,
        6, 7, 8, 9, 10
    );

    // Default Parallel Stream
    System.out.println("Default Parallel Stream:");

    // Process the list using a parallel stream. It will open threads equals to number of cores
    numbers.parallelStream()
        // Print the thread name processing the current element
        .peek(num -> System.out.println(
            Thread.currentThread().getName() + " processing " + num))
        .forEach(num -> {
        });

    // Custom Parallel Stream with a limited number of threads
    ForkJoinPool customThreadPool =
        new ForkJoinPool(4);
    // Create a custom ForkJoinPool with a maximum of 4 threads

    System.out.println("\nCustom Parallel Stream with 4 Threads:");

    // Submit a task to the custom ForkJoinPool
    customThreadPool.submit(() ->
        numbers.parallelStream() // Use the parallel stream
            .peek(num -> System.out.println(
                Thread.currentThread().getName() + " processing "
                    + num)) // Print the thread name processing the current element
            .forEach(num -> {
            }) // Process each element in parallel (no specific operation here)
    ).get(); // Wait for the task to complete

    // Shut down the custom ForkJoinPool
    customThreadPool.shutdown();

  }
}

