package Threads.Concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int threadNumber = i;

            new Thread(() -> {
                String key = "Key # " + threadNumber;

                for (int j = 0; j < 3; j++) {
                    String value = getValue(key);
                    System.out.println("Thread " + Thread.currentThread().getName() + " key: " + key + ", value: " + value);
                }
            }).start();
        }
    }

    private static String getValue(String key) {
        String value = cache.get(key);

        if (value == null) {
            value = compute(key);
            cache.put(key, value);
        }
        return value;
    }

    private static String compute(String key) {
        System.out.println(key + " is not present so going to compute it....");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "value of key - " + key;
    }

}
