package Generics;

import java.util.Arrays;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {

//        display(Arrays.asList(1,1,4,56));
//        List<? super Integer> li = Arrays.asList(1,2,5.9);
//        li.add(6); // can add because Super means the super class of Integer is also in here so we can add
//        display(li);

        List<? extends Number> li2 = Arrays.asList(1,2,5.9);
        display1(li2);

    }

    public static double display(List<?> li) {
        System.out.println(li);
        return 0;
    }

    // bounded wildcard
    public static void display1(List<? extends Number> li) {
        // li.add(67); read-only
        double sum = 0;
        for(Number o: li) {
            sum += o.doubleValue();
        }
        System.out.println(sum);
    }



}
