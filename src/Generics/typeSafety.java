package Generics;

import java.util.ArrayList;

public class typeSafety {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("Alpha");
        arr.add(68);
        String o = (String) arr.get(0); // manual type casting
//        String str = arr.get(0); not type safe
//        System.out.println(o);

        // Solution
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        int a = integers.get(0);
        System.out.println(a);
    }
}
