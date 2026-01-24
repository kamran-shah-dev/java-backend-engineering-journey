package OOP.Lambda_Expressions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class lambdaExpression {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>();

        for (int i = 0; i < 6; i++) numbs.add(i);

        // numbs.forEach(System.out::println); // method reference
        // numbs.forEach((n) -> { // lambda expression
        //    System.out.println(n);
        // });

        Consumer<Integer> numbers = System.out::println; // lambda expression can be stored in a variable

        numbs.forEach(numbers);
    }
}
