package Maps.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMaps {

        public static void main(String[] args) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
            // Java 7 -- > segment based locking -- > 16 segments -- > smaller hashmaps
            // Only the segment being written to or read from is locked
            // read: do not require locking unless there is a write operation happening on the same segment
            // write: lock

            // java 8 -- > no segmentation
            //        -- > Compare-And-Swap approach -- > no locking except resizing or collision (because collission
            //             occurs when two keys have the same hashCode so they will reside in same bucket, in that case
            //             let's say two threads approach to add new node in same bucket there it will be a conflict
            //             so in java 8 there we will apply a lock. Secondly if the linked list converts to RBT at that time
            //             it's structure will change so it will be locked untill conversion is complete.
            //        In case of resizing, it is s
            // Thread A Last saw -- > x = 45
            // Thread A work -- > x to 50
            // if x is still 45, then change it to 50 else don't change and retry
            // put -- > index
        }
}



class Node {
    int key;
    String value;
    int hash;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.hash = Integer.hashCode(key);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

public class ResizeSimulation {

    public static void main(String[] args) {

        int oldCapacity = 4;
        int newCapacity = oldCapacity * 2;

        // Old table (array of buckets)
        List<Node>[] oldTable = new LinkedList[oldCapacity];

        for (int i = 0; i < oldCapacity; i++) {
            oldTable[i] = new LinkedList<>();
        }

        // Add some elements
        insert(oldTable, oldCapacity, new Node(1, "A"));
        insert(oldTable, oldCapacity, new Node(5, "B"));
        insert(oldTable, oldCapacity, new Node(9, "C"));
        insert(oldTable, oldCapacity, new Node(13, "D"));

        System.out.println("=== BEFORE RESIZE ===");
        printTable(oldTable);

        // New table
        List<Node>[] newTable = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        // 🔥 RESIZE LOGIC (CORE PART)
        for (int i = 0; i < oldCapacity; i++) {
            for (Node node : oldTable[i]) {

                // 🔁 IMPORTANT SPLITTING LOGIC
                if ((node.hash & oldCapacity) == 0) {
                    // stays at same index
                    newTable[i].add(node);
                } else {
                    // moves to index + oldCapacity
                    newTable[i + oldCapacity].add(node);
                }
            }
        }

        System.out.println("\n=== AFTER RESIZE ===");
        printTable(newTable);
    }

    static void insert(List<Node>[] table, int capacity, Node node) {
        int index = node.hash % capacity;
        table[index].add(node);
    }

    static void printTable(List<Node>[] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println("Bucket " + i + ": " + table[i]);
        }
    }
}