package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kamran", "adnan" , "farooq");
        Stream<String> name = names.stream();
    }
}
