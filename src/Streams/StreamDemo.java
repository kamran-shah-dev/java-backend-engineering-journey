package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // feature introduced in Java 8
        // process collections of data in a functional and declarative manner
        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism

        // What is stream ?
        // a sequence of elements supporting functional and declarative programing

        // How to Use Streams ?
        // Source, intermediate operations & terminal operation

        // Example - Taking a list and counting number of even numbers in that.
        List<Integer> numbers = Arrays.asList(1,2,5,8,0,5,4);
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

        // Creating Streams
        // 1. Converting list to a stream
        List<String> names = Arrays.asList("Alpha", "Beta" , "Gamma");
        Stream<String> namees = names.stream();

        // 2. Creating from arrays
        Integer[] a = {1,2,3,4,5,6,7,8};
        Stream<Integer> numbers2 = Arrays.stream(a);

        // 3. using Stream.of()
        Stream<String> st1 = Stream.of("Alpha", "Beta", "Gamma");

        // 4. Infinite Streams
        Stream<Integer> newStream = Stream.generate(() -> 1).limit(10);
        Stream<Integer> newStream1 = Stream.iterate(4, x -> x + 4).limit(10);
    }
}
