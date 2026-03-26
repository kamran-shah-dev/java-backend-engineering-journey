package Collections.List.vectors;

import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        // vectors exist before the collections were introduced
        // they are synchronized, hence thread safe
        // due to synchronization they have a overhead
        // if single thread is used so ArrayList is recommended instead of vectors
        // it is a legacy class
        // contains functions like other lists

        Vector<Integer> vect = new Vector<>(); // initial capacity 10 by default
        vect.add(1);
        vect.add(2);
        vect.add(3);
        vect.add(2, 5); // add at index

        // Other functions work the same as worked in LinkedList and ArrayList


        // -------------- Sorting -----------------
        /*

        System.out.println(vect);
        vect.sort(null);
        System.out.println(vect);
        vect.sort((n1, n2) -> n2 - n1);
        System.out.println(vect);

        */


        // ---------------- checking capacity -----------------
        /*

        Vector<Integer> vect2 = new Vector<>(3); // initial capacity
        vect2.add(1);
        vect2.add(2);
        vect2.add(3);
        System.out.println(vect2.capacity()); // initial capacity : 3
        vect2.add(4);
        System.out.println(vect2.capacity()); // if we add more elements now capaciy becomes double
        // so initial capacity * 2

        Vector<Integer> vect3 = new Vector<>(2, 3); // capacity increment (by default it gets doubled)
        vect3.add(1);
        vect3.add(2);

        System.out.println(vect3.capacity()); // initial capacity 2
        vect3.add(3);
        System.out.println(vect3.capacity()); // more elements so initial capacity + capacity increment = 5

         */
     }
}
