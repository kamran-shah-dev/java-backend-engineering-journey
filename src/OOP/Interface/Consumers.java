package OOP.Interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {
    public static void main(String[] args) {
        Consumer <List<String>> first_consumer = list -> {
            for(String name : list) {
                System.out.println(name + " 1");
            }
        };
        Consumer<List<String>> second_consumer = li -> {
            for(String x : li) {
                System.out.println(x);
            }
        };
        second_consumer.andThen(first_consumer).accept(Arrays.asList("Alpha" , "Beta"));

    }
}
