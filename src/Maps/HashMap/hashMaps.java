package Maps.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashMaps {
    public static void main(String[] args) {
        HashMap<Integer, String> orders = new HashMap<>();
        orders.put(1, "10 KG");
        orders.put(2, "30 KG");
        orders.put(3, "40 KG");

        System.out.println(orders.get(2)); // fetching values
        System.out.println(orders.containsKey(2)); // finding if a key exists or not
        System.out.println(orders.containsValue("10 KG")); // finding if a value exists or not
        System.out.println(orders); // print as a dictionary


        // HashMap functions
        // Put Functions
        orders.putIfAbsent(4, "60 KG"); // if not present it will add
        orders.putAll(Map.of(5, "70 KG", 6, "90 KG"));

        // Compute functions
        orders.compute(2, (key, value) -> value = "20KG"); // if present it will update that otherwise it will add a new one
        orders.computeIfPresent(4, (key, value) -> value = "50KG"); // if present it will update otherwise does nothing
        orders.computeIfAbsent(2, value -> "50KG"); // if absent it will add a new one otherwise do nothing.
        System.out.println(orders.computeIfAbsent(9, key -> "50 KG"));


        // Iterate through HashMap
        // using keySet()

        Set<Integer> keys = orders.keySet();
        for (int i : keys) // or directly for (int i : orders.keySet()) - Serves the same
            System.out.println(orders.get(i));

        // using entrySet()
        Set<Map.Entry<Integer, String>> Orders = orders.entrySet();
        for (Map.Entry<Integer, String> o : Orders) // or directly for (Map.Entry<Integer, String> o : orders.entrySet()) - Serves the same
            System.out.println(o.getKey() + " :: " + o.getValue());
    }
}
