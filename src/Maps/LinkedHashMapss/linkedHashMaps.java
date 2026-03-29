package Maps.LinkedHashMapss;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class linkedHashMaps {
    public static void main(String[] args) {
        /*
         * In HashMap, insertion order and access order do not matter — the map makes no
         * guarantees about iteration order. If ordering is needed, we use LinkedHashMap.
         *
         * LinkedHashMap maintains order using an internal doubly linked list, and since it
         * extends HashMap it inherits all HashMap functionality. By default it preserves
         * INSERTION ORDER. Setting accessOrder to true switches it to ACCESS ORDER (LRU),
         * meaning the most recently accessed entry moves to the end of the iteration order.
         */

        // 4 constructors:
        // LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
        // LinkedHashMap<Integer, String> students = new LinkedHashMap<>(initialCapacity: 3);
        // LinkedHashMap<Integer, String> students = new LinkedHashMap<>(initialCapacity: 3, loadFactor: 0.3f);
        // LinkedHashMap<Integer, String> students = new LinkedHashMap<>(initialCapacity: 3, loadFactor: 0.3f, accessOrder: true);

        LinkedHashMap<Integer, String> students = new LinkedHashMap<>(4, 0.1f, true);
        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");

        students.get(1); // accessing key 1 moves it to the end of the access-order list

        Set<Map.Entry<Integer, String>> stds = students.entrySet();
        for (Map.Entry<Integer, String> std : stds) {
            System.out.println(std.getKey() + " : " + std.getValue());

            /*
             * Since accessOrder = true, iteration reflects ACCESS ORDER (LRU order).
             * Keys 2 and 3 were not accessed after insertion, so they come first.
             * Key 1 was accessed last via students.get(1), so it appears at the end.
             *
             * Expected output:
             *   2 : Bob
             *   3 : Charlie
             *   1 : Alice
             *
             * If accessOrder were false (the default), iteration would reflect
             * INSERTION ORDER — the order in which keys were put into the map:
             *
             *   1 : Alice
             *   2 : Bob
             *   3 : Charlie
             */
        }
    }
}
