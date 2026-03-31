package Maps.HashMap;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("Alpha" , 1);
        table.put("beta" , 2);

        for (Map.Entry<String, Integer> m : table.entrySet())
            System.out.println(m.getKey() + " : " + m.getValue());
        // Notes written below

        // Thread Example
        Hashtable<Integer, Integer> list = new Hashtable<>();
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 3000; i++) {
                        list.put(i , i+1);
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 3000; i < 6000; i++) {
                        list.put(i , i+1);
                    }
                }
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());

        // if the data structure is synchronized answer will be 6000 like HashTable is
        // But if the data structure is not synchronized the answer will be 4864 because no no thread safety
    }
}


/*
====================== HASH TABLE (LEGACY) - COMPLETE NOTES ======================

• Overview:
  - HashTable is a legacy class from Java 1.0.
  - It implements a hash-based key-value data structure.
  - Part of java.util package.
  - It is similar to HashMap but with key differences.

-------------------------------------------------------------------------------

• Key Characteristics:

  - Stores data in key-value pairs.
  - Uses hashing to store and retrieve elements efficiently.
  - Keys are unique (no duplicate keys allowed).
  - Values can be duplicated.

-------------------------------------------------------------------------------

• Null Handling:

  - DOES NOT allow null keys.
  - DOES NOT allow null values.
  - If you try to insert null → NullPointerException.

-------------------------------------------------------------------------------

• Synchronization & Thread Safety:

  - Fully synchronized (thread-safe by default).
  - Every method is synchronized.
  - Safe for multi-threaded environments.

-------------------------------------------------------------------------------

• Performance:

  - Slower than HashMap due to synchronization overhead.
  - Not preferred in single-threaded environments.

-------------------------------------------------------------------------------

• Why It Is Considered Legacy:

  - Introduced before the Java Collections Framework.
  - Later replaced by better alternatives like:
        → HashMap (non-synchronized, faster)
        → ConcurrentHashMap (thread-safe & efficient)

-------------------------------------------------------------------------------

• Replacement:

  - ConcurrentHashMap is preferred because:
        → Thread-safe without locking entire map
        → Better performance in multi-threaded systems
        → Allows concurrent reads and writes
        → More scalable than HashTable

-------------------------------------------------------------------------------

• Internal Working:

  - Uses an array of buckets (hash table).
  - Each bucket stores entries using chaining (linked list).
  - Index calculated using hash function:
        index = hash(key) % capacity

-------------------------------------------------------------------------------

• Load Factor & Capacity:

  - Default capacity: 11
  - Default load factor: 0.75
  - When threshold exceeded → rehashing occurs.

-------------------------------------------------------------------------------

• Constructors:

  - HashTable()
  - HashTable(int initialCapacity)
  - HashTable(int initialCapacity, float loadFactor)
  - HashTable(Map<? extends K, ? extends V> m)

-------------------------------------------------------------------------------

• Common Methods:

  - V put(K key, V value)
        → Inserts or updates a key-value pair.

  - V get(Object key)
        → Returns value associated with key.

  - V remove(Object key)
        → Removes mapping for key.

  - boolean containsKey(Object key)
        → Checks if key exists.

  - boolean contains(Object value)   (LEGACY)
        → Checks if value exists.

  - boolean containsValue(Object value)
        → Preferred method for value check.

  - boolean isEmpty()
        → Checks if table is empty.

  - int size()
        → Returns number of elements.

  - void clear()
        → Removes all elements.

-------------------------------------------------------------------------------

• Traversal Methods:

  - Enumeration<K> keys()
        → Returns all keys.

  - Enumeration<V> elements()
        → Returns all values.

  - Set<K> keySet()
        → Returns set of keys.

  - Collection<V> values()
        → Returns collection of values.

  - Set<Map.Entry<K, V>> entrySet()
        → Returns key-value pairs.

-------------------------------------------------------------------------------

• Advanced / Utility Methods:

  - V putIfAbsent(K key, V value)
        → Inserts only if key is absent.

  - boolean remove(Object key, Object value)
        → Removes only if key-value matches.

  - boolean replace(K key, V oldValue, V newValue)
        → Replaces value if match found.

  - V replace(K key, V value)
        → Replaces value for given key.

-------------------------------------------------------------------------------

• Differences: HashTable vs HashMap

        HashTable                 | HashMap
        --------------------------|-------------------------
        Synchronized              | Not synchronized
        Thread-safe               | Not thread-safe
        No null key/value         | Allows 1 null key & null values
        Slower                    | Faster
        Legacy class              | Modern (JCF)

-------------------------------------------------------------------------------

• When to Use:

  - Rarely used today.
  - Only when:
        → You need strict thread safety
        → And working with legacy code

  - Otherwise prefer:
        → HashMap (single-threaded)
        → ConcurrentHashMap (multi-threaded)

-------------------------------------------------------------------------------

• Summary:

  - HashTable is a thread-safe but outdated collection.
  - It suffers from performance issues due to full synchronization.
  - Replaced by more efficient and scalable alternatives.
  - Still important for understanding legacy Java systems.

===============================================================================
*/