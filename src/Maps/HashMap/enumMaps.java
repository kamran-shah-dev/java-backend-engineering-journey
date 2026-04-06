package Maps.HashMap;

import java.util.EnumMap;
import java.util.Map;

public class enumMaps {
    public static void main(String[] args) {
        // EnumMap is a special Map optimized for enum keys.
        // It uses an internal array (not hashing), so it is fast and memory efficient.
        // The order of keys is the same as the enum declaration order.
        // ordinal() returns the index of the enum constant (starting from 0).

        Map<Days, String> daysAndTasks = new EnumMap<>(Days.class);
        daysAndTasks.put(Days.MONDAY, "4 Hours Requirement Engineering Finalization");

        System.out.println(daysAndTasks);
    }
}

enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}