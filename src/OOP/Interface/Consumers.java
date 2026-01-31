package OOP.Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {
    public static void main(String[] args) {
        Consumer <String> str = System.out::println;
        str.accept("Hello Java");

        Consumer <ArrayList<Integer>> numbers = list -> {
            for(Integer li : list) {
                System.out.println(li);
            }
        };
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        numbers.accept(list);

    }
}
