package Collections.LinedHashMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capatity) {
        super(capatity, 0.4f, true);
        this.capacity = capatity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }


    public static void main(String[] args) {
        LRUCache<Integer, String> students = new LRUCache<>(4);
        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");
        students.put(4, "Joan");

        students.get(2);
        students.put(5, "Joel");

        Set<Map.Entry<Integer, String>> stds = students.entrySet();
        for (Map.Entry<Integer, String> std : stds) {
            System.out.println(std.getKey() + " : " + std.getValue());
        }
    }
}
