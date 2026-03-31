package Maps.HashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMaps {
    public static void main(String[] args) {
        /*
        * Identity hashMap and hashMap have a very basic ddifference in between and that is, the hashmap uses the hashCode
        * of the data type which uses the data to create an hashCode (except class - but we can override class's hashCodes
        * to work with content) and the equals method to check the content. So if we do like:
        *
        String s1 = new String("k1");
        String s2 = new String("k1");

        Map<String, Integer> values = new HashMap<>();
        values.put(s1, 50);
        values.put(s2, 60);

        System.out.println(values);
        System.out.println("Observing the equals method and the hashCode: ");
        System.out.println("Both strings are equal: " + s1.equals(s2));
        System.out.println(s1.hashCode() + " = " + s2.hashCode() + " ? " + (s1.hashCode() == s2.hashCode()));
        *
        * We will observe an Output:
        {k1=60}
        Observing the equals method and the hashCode:
        Both strings are equal: true
        3366 = 3366 ? true
        *
        * That means HashMap does consider the hashCode of string not the object even though we use the new
        * keyword.
        *
        * Now moving on to identityHashMap, this is the vice versa of HashMap, it uses the Objects hashCode even
        * if we override that, also it uses the memory reference equality check (==); so the same example in case of
        * IdentityHashmap will produce a map with two key-value pairs even though both keys are same.
        *
        * */


        String s1 = new String("k1");
        String s2 = new String("k1");

        Map<String, Integer> values = new IdentityHashMap<>();
        values.put(s1, 50);
        values.put(s2, 60);

        System.out.println(values);
        System.out.println("Observing the equals method and the hashCode: ");
        System.out.println("Both strings are equal: " + s1.equals(s2));
        System.out.println(s1.hashCode() + " = " + s2.hashCode() + " ? " + (s1.hashCode() == s2.hashCode()));

        /*
        * So the output will be:
        {k1=60, k1=50} // Created two elements
        Observing the equals method and the hashCode:
        Both strings are equal: true
        3366 = 3366 ? true
        * */


    }
}
