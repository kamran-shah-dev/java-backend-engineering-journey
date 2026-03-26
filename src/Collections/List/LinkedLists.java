package Collections.List;

import java.util.*;

public class LinkedLists {
    public static void main(String[] args) {
        // LinkedList present in List just like arrayList is another collection that behaves like a doubly linked-list
        // and also it behaves like a list (using index)

        LinkedList<String> days = new LinkedList<>();

        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        days.add("Holiday1");
        days.add("Holiday2");
        days.add("Holiday3");

        // adding elements using addfirst, addlast and index
        days.addFirst("Monday");
        days.addLast("Holiday4");
        days.add("Holiday6"); // same as addLast
        days.add(7, "Holiday0"); // add at any place
        // System.out.println(days);

        /*
        // fetching elements
        System.out.println(days.getFirst());
        System.out.println(days.getLast());
        System.out.println(days.get(4));
        System.out.println(days.getClass());  // Get class of the days object.

        // update
        days.set(7, "Holiday1");
        System.out.println(days.get(7));

        // find, info
        System.out.println(days.contains("Holiday1"));
        System.out.println(days.indexOf("Holiday1"));
        System.out.println(days.size());

        // removal
        days.remove(); // remove first element
        System.out.println(days);
        days.remove("Holiday2");
        System.out.println(days);
        days.remove(9);
        System.out.println(days);
        days.removeFirst(); // remove first
        days.removeLast(); // remove last
        days.removeFirstOccurrence("Holiday1"); // if duplicates, remove first duplicate
        days.removeLastOccurrence("Holiday1"); // if duplicates, remove last duplicate

        LinkedList<String> weekDays= new LinkedList<>(Arrays.asList("Monday" , "Tuesday", "Wednesday" ,"Thursday" , "Friday" , "Saturday" , "Sunday"));
        LinkedList<String> daysToRemove = new LinkedList<>(Arrays.asList("Thursday" , "Friday"));
        weekDays.removeAll(daysToRemove);
        System.out.println(weekDays);

        weekDays.removeIf(x -> Objects.equals(x, "Tuesday"));
        System.out.println(weekDays);

         */


        //---------------- Iteration methods --------------------
        /*

        System.out.println("Using Pointer");
        for (int i = 0; i < days.size(); i++) {
            System.out.print(days.get(i) + " ");
        }

        System.out.println("\nUsing ForEach");
        for (String st: days) {
            System.out.print(st + " ");
        }

        System.out.println("\nUsing Iterator");
        Iterator<String> it = days.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() +  " ");
        }

        */


        //----------------- Using LinkedList as Queue ------------------
        /*

        days.offer("New Holiday"); // add at last
        System.out.println(days);

        System.out.println(days.peek()); // return first element
        System.out.println(days.poll()); // pop first element
        System.out.println(days);

        */


        //------------- Using LinkedList as Stack ---------------
        /*

        days.push("New Day");
        System.out.println(days);

        System.out.println(days.pop());
        System.out.println(days);

         */
    }
}
