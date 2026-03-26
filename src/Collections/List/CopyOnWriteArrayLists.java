package Collections.List;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayLists {
    public static void main(String[] args) {
        // "Copy on Write" means that whenever a write operation
        // Like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // This ensures that other threads reading the list while it's being modified are unaffected.

        // Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
        // Write Operations: A new copy of the list is created for every modification.
        //       The reference to the list is then updated so that subsequent reads use this new list.

        // notepad -- > notepad-copy

        // read more - Recommended to use only if the program is read intensive

        /*

        List<Integer> newList = new CopyOnWriteArrayList<>();

        newList.add(1);
        newList.add(2);
        newList.add(3);

        for (Integer i: newList) {
            System.out.println(i);
            if(i == 2) {
                newList.add(6); // will through a concurrent exception thread if it is Arraylist of LinkedList
                System.out.println(i);
            }
        }
        System.out.println(newList); // now it will point to the new copy of the list
        */


        // Understanding this using threads
        List<String> users = new CopyOnWriteArrayList<>();
        users.add("Ali");
        users.add("Fatima");
        users.add("Asghar");


        Thread reader = new Thread(() -> {
            try {
                while (true) {
                    for (String i:users) {
                        System.out.println("User: " + i);
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(500);
                users.add("Amjad");
                System.out.println("New User Appeared");

                Thread.sleep(500);
                users.remove("Asghar");
                System.out.println("User Removed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        reader.start(); writer.start();

    }
}
