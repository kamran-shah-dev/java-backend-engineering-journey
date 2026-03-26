package Collections.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CompareVal implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
        return n2 - n1;
        // if value is negative return n1, if positive return n2 and if zero both have same order
    }
}

public class Int_Comparison {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(1);
        values.add(8);
        values.add(2);
        values.add(1);

        values.sort(null); // sorts in ascending order
        System.out.println(values);

        // what if we want to change the order (like sort in descending)?
        // we will use comparator (compares two objects and returns a +ve, -ve or 0 based on the logic
        // Method-1 Implementing Comparator class (Overriding compare method)
        //   values.sort(new CompareVal());
        System.out.println(values);

        // Method-2 Using lambda expression
        values.sort((n1, n2) -> n2 - n1);
        System.out.println(values);
    }
}
