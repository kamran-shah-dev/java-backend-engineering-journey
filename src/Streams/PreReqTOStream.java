package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class PreReqTOStream {
    public static void main(String[] args) {

        MethodReferenceDemo.methodRefDemo();

        /*
        =========================================================
        🔹 1. LAMBDA EXPRESSIONS
        =========================================================
        - Used to implement functional interfaces (single abstract method)
        - Provides a concise way to write anonymous functions

        Example: Implementing a custom functional interface
        */
        calc c = (a,b) -> a + b;
        // System.out.println("value is: " + c.calculation(5,6)); // 11


        /*
        =========================================================
        🔹 2. PREDICATE (Boolean Condition Logic)
        =========================================================
        - Takes input → returns boolean
        - Commonly used for filtering and condition checks
        */
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        // System.out.println(isOdd.test(5)); // true

        Predicate<String> startsWith = x -> x.startsWith("K");
        Predicate<String> endsWith = x -> x.toLowerCase().endsWith("n");

        // Combining conditions
        Predicate<String> andcondition = startsWith.and(endsWith); // BOTH must be true
        Predicate<String> orcondition = startsWith.or(endsWith);   // ANY one true
        Predicate<String> not = Predicate.not(endsWith);           // Negates condition

        // System.out.println("Checking not: " + not.test("Kamran"));  // false
        // System.out.println(andcondition.test("Kamran")); // true
        // System.out.println(orcondition.test("Adnan")); // false

        // Equality check using Predicate
        Predicate<String> isKamran = Predicate.isEqual("Kamran");
        Predicate<String> notIsKamran = isKamran.negate();

        // System.out.println(isKamran.test("Kamran")); // true
        // System.out.println(notIsKamran.test("Abdullah")); // true


        /*
        =========================================================
        🔹 3. FUNCTION (Transformation Logic)
        =========================================================
        - Takes input → returns a value
        - Used for data transformation
        */
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> cube = x -> x * x * x;

        // Function chaining
        // andThen → executes left → right
        // compose → executes right → left

        // System.out.println(square.andThen(cube).apply(5)); // (5^2)^3
        // System.out.println(square.compose(cube).apply(5)); // (5^3)^2

        // Identity → returns input as-is
        Function<Integer, Integer> identity = Function.identity();
        // System.out.println(identity.apply(6));


        /*
        =========================================================
        🔹 4. CONSUMER (Consumes Data, No Return)
        =========================================================
        - Takes input → returns nothing
        - Used for side effects (printing, logging, etc.)
        */
        Consumer<Integer> printNum = x -> System.out.println("Value is: " + x);
        printNum.accept(6);

        List<Character> vowels = Arrays.asList('a', 'e', 'i' , 'o', 'u');

        Consumer<List<Character>> printChar = x -> {
            for (Character ch : x) {
                System.out.println(ch);
            }
        };
        printChar.accept(vowels);


        /*
        =========================================================
        🔹 5. SUPPLIER (No Input → Returns Value)
        =========================================================
        - Does NOT take input
        - Always returns something
        */
        Supplier<Integer> getvalue = () -> 100;
        System.out.println(getvalue.get());


        /*
        =========================================================
        🔹 6. UNARY OPERATOR (Special Case of Function)
        =========================================================
        - Input and output types are SAME
        */
        UnaryOperator<Integer> squareit = x -> x * x;


        /*
        =========================================================
        🔹 7. BI-FUNCTIONAL INTERFACES (Two Inputs)
        =========================================================
        */

        // 🔹 BiPredicate → (2 inputs → boolean)
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;

        System.out.println("BiPredicate:");
        System.out.println("Is (3 + 5) even? " + isSumEven.test(3, 5));
        System.out.println("Is (3 + 4) even? " + isSumEven.test(3, 4));


        // 🔹 BiFunction → (2 inputs → result)
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        System.out.println("\nBiFunction:");
        System.out.println("Multiplication of 4 and 5: " + multiply.apply(4, 5));

        // Chaining BiFunction with Function
        Function<Integer, Integer> square2 = x -> x * x;
        System.out.println("Multiply then square (2,3): " +
                multiply.andThen(square2).apply(2, 3));


        // 🔹 BiConsumer → (2 inputs → no return)
        BiConsumer<String, Integer> printDetails = (name, age) ->
                System.out.println("Name: " + name + ", Age: " + age);

        System.out.println("\nBiConsumer:");
        printDetails.accept("Kamran", 22);


        // Chaining BiConsumers
        BiConsumer<String, Integer> greet = (name, age) ->
                System.out.println("Hello " + name + "!");

        System.out.println("\nBiConsumer Chaining:");
        printDetails.andThen(greet).accept("Kamran", 22);


        /*
        =========================================================
        🔹 FINAL NOTE
        =========================================================
        - These functional interfaces are the foundation of:
          ✔ Streams API
          ✔ Method References
          ✔ Functional Programming in Java
        */

    }
}

@FunctionalInterface
interface calc {
    public int calculation(int a, int b);
}

class MethodReferenceDemo {
    public static void methodRefDemo() {

        /*
        =========================================================
        🔹 METHOD REFERENCES
        =========================================================
        - A shorthand for lambda expressions
        - Used when lambda ONLY calls an existing method
        */

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        // Lambda version
        numbers.forEach(num -> System.out.print(num));

        System.out.println(" ");

        // Method Reference version (cleaner)
        numbers.forEach(System.out::print);


        /*
        =========================================================
        🔹 STATIC / INSTANCE METHOD REFERENCE
        =========================================================
        */
        Function<String, Integer> strLength = String::length;
        System.out.println(strLength.apply("Alpha"));


        /*
        =========================================================
        🔹 CUSTOM METHOD REFERENCE
        =========================================================
        */
        Predicate<Integer> isEven = mathsUtil::evenOrOdd;
        System.out.println(isEven.test(6));


        /*
        =========================================================
        🔹 CONSTRUCTOR METHOD REFERENCE
        =========================================================
        - Used to create objects dynamically
        - Equivalent to: () -> new ArrayList<>()
        */
        Supplier<List<Integer>> list = () -> new ArrayList<>();
        Supplier<List<Integer>> list2 = ArrayList::new;

        List<Integer> l1 = list.get();
        l1.add(1);
        l1.add(2);

        System.out.println(l1);
    }

    static class mathsUtil {
        static boolean evenOrOdd(int n) {
            return n % 2 == 0;
        }
    }
}