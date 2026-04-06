package Maps.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMaps {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Kamran");
        students.put(2, "Adnan");

        Map<Integer, String> map3 = Collections.unmodifiableMap(students);
        System.out.println(map3);
        // map3.put(4, "Azlan"); throws excpetion because this is Immutalbe

        Map<String, Integer> tests = Map.of("Bio" , 55, "Maths", 45,"Urdu",50);
        // This returns an immutable map with default size of 10 so if we try to modify it it will give throw
        // unsupported operation exception
        // tests.put("English", 90);

        // Map.of has the capacity of 10 so instead of that for bigger maps we will use Map.ofEntries method
        Map<String, Integer> newTests = Map.ofEntries(Map.entry("Urdu" , 40), Map.entry("English" , 90));
        System.out.println(newTests);
    }
}
