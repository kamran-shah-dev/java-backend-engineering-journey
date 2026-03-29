package Maps.HashMap.WeakHashMaps;

import java.util.WeakHashMap;

public class Demo1 {
    public static void main(String[] args) {
        WeakHashMap<String, Student> toBeCached = new WeakHashMap<>();

        // we know when string literals are created they are kept in String pool and they be there till
        // end of the program so this way even having a WeakHashMap the keys will not be destroyed after
        // sometime.
        // So to make it really a usage of WeakHashMap we will create new string values instead of literals

        /*

        toBeCached.put("001", new Student("Alice" , 100));
        toBeCached.put("002", new Student("Bob" , 99));
        toBeCached.put("003", new Student("Charlie" , 70));

         */

        // now the WeakHashMap will be empty after sometime
        toBeCached.put(new String("001"), new Student("Alice" , 100));
        toBeCached.put(new String("002"), new Student("Bob" , 99));
        toBeCached.put(new String("003"), new Student("Charlie" , 70));


        System.out.println(toBeCached);
        System.gc();
        try {
            System.out.println("Simulating WeakHashMap destruction after sometime...");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(toBeCached);

        // ---- OutPut------- in case of string literals
        /*
        * {003=Student{name='Charlie', marks=70}, 002=Student{name='Bob', marks=99}, 001=Student{name='Alice', marks=100}}
        * Simulating WeakHashMap destruction after sometime...
        * {003=Student{name='Charlie', marks=70}, 002=Student{name='Bob', marks=99}, 001=Student{name='Alice', marks=100}}
        * */

        // ---- OutPut------- in case of new Strings
        /*
        * {003=Student{name='Charlie', marks=70}, 002=Student{name='Bob', marks=99}, 001=Student{name='Alice', marks=100}}
        * Simulating WeakHashMap destruction after sometime...
        * {}
        * */
    }
}
class Student {
    private final String name;
    private final int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

