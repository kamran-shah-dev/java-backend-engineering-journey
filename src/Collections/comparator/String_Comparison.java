package Collections.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CompareStr implements Comparator<String> {
    @Override
    public int compare(String n1, String n2) {
        return n2.length() - n1.length();
        // if value is negative return n1, if positive return n2 and if zero both have same order
    }
}

public class String_Comparison {

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("Cake");
        values.add("IceCream");
        values.add("MilkShake");
        values.add("vanilla");
        values.add("Juice");

        values.sort(null); // sorts in ascending order
        System.out.println(values);

        // what if we want to change the order (like sort in descending)?
        // we will use comparator (compares two objects and returns a +ve, -ve or 0 based on the logic
        // Method-1 Implementing Comparator class (Overriding compare method)
        //   values.sort(new CompareStr());
        System.out.println(values);

        // Method-2 Using lambda expression
        values.sort((n1, n2) -> n2.length() - n1.length());
        System.out.println(values);
    }
}
