package Collections.List;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        // adding elements
        list.add(10);
        list.add(20);
        list.add(30);

        /*System.out.println(list.get(2)); // getting single element

        // print arraylist as a list
        System.out.println(list);

        // accessing elements using pointer.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // using enhanced for loop (foreach loop)
        for(Integer i: list) {
            System.out.println(i);
        }
        */

        // contains function to check how many elements are there in list.

        /* System.out.println(list.contains(20)); */

        // adding elements using index/at start/at end & removing element from list
        /* list.add(2, 40);
        list.addFirst(10);
        list.addLast(50);

        list.remove(1); //remove by index
        list.remove(Integer.valueOf(2)); // remove by value
        // to remove first element use removeFirst
        // to remove last element use removeLast
        for(Integer i: list) {
            System.out.println(i);
        } */


        // replace elements use set() method with, provide index and new value
        /* list.set(2, 60);

        System.out.println(list.get(2)); */

        // by default the initial capacity of an ArrayList is : 10, when more than 10 elements
        // are added then the capacity will grow by current capacity * 1.5

        /* ArrayList<Integer> list2 = new ArrayList<>(20);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
         */

        // Arrays.asLis. We cannot add or remove elements in here but we can replace elements here.
        /*String[] arr = {"Monday" , "Sunday" , "Friday"};
        // ArrayList<String> days = Arrays.asList(arr);
        List<String> days = Arrays.asList(arr);
        System.out.println(days);

        // List.of, is immutable and does not allow add, remove or replace elements

        List<Integer> val = List.of(1,2,3,4,5,6);
        System.out.println(val);
        */

        // We can crate an ArrayList from another collection
       /* List<Integer> val = List.of(1,2,3,4,5,6);
        ArrayList<Integer> copy = new ArrayList<>(val);
//        System.out.println(copy);

        List<Integer> val2 = new ArrayList<>();
        val2.add(10);
        val2.add(30);

        List<Integer> val3 = Arrays.asList(1,2,3,4,5,6);

        //  val3.addAll(val2); exception we cannot add ArrayList to Arrays$ArrayList

        val2.addAll(val3);
        val2.addAll(val);
        System.out.println(val2);


        */



        // converting ArrayList to array
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(30);
        arr.add(20);
        arr.add(15);
        arr.add(25);

        Object[] array = arr.toArray();

        Integer[] newArray = arr.toArray(new Integer[0]);

        for (Integer i: newArray) {
            System.out.println(i);
        }


        // sorting a list
        arr.sort(null);
        System.out.println(arr);

        // to use ArrayList as a stack (not recommended)
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(10);
        arr2.add(30);
        arr2.add(20);
        arr2.add(15);
        arr2.add(25);

        // PEEK - (Get Top)
        System.out.println("Top element: " + (arr2.getLast()));

        // POP - (Remove top)
        System.out.println("Popped: " + (arr2.removeLast()));
    }
}
