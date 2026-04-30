package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
        // from list
        List<String> fruits = List.of("Banana" , "Mango" , "Orange" , "Apple");
        Stream<String> st = fruits.stream();
        st.forEach(System.out::print);

        // from array
        System.out.println();
        int [] arr = {1,3,5,7,9};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::print);

        Stream<Integer> nums = Arrays.stream(new Integer[]{1,2,3,4,5});


        // from direct values
        System.out.println();
        Stream<Double> st2 = Stream.of(2.3, 3.4, 5.6);
        st2.forEach(System.out::println);

        // usign iterate method
        System.out.println();
        Stream<Integer> st3 = Stream.iterate(1, n -> n + 2);
        Stream<Integer> st4 = Stream.iterate(2, n -> n < 20, n -> n++); // Advanced version
        st3.limit(10).forEach(System.out::println);

        // using generate method
        System.out.println();
        Stream<Double> random = Stream.generate(() -> Math.random()*4);
        random.limit(10);
        random.forEach(System.out::println);


        // From File
        Stream<String> fileText = Files.lines(Path.of("src/Streams/file.txt"));



        // using Stream builder
        Stream<String> vegetables = Stream.<String>builder()
                .add("Lady Finger")
                .add("PumpKin")
                .build();


        // From Strings
        "Alpha Beta Gamma".chars().forEach(System.out::println);
        Stream<String> letters = "a,b,c,d,e,f".lines();

        // From Maps
        Map<String, Integer> map = Map.of("ALpha" , 1, "Beta" , 2);

        map.keySet().stream();
        map.values().stream();
        map.entrySet().stream();


    }
}
