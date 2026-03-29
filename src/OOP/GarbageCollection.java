
/*A strong reference is an object that is created in heap. So when we create an object like:
     Object obj = new Object();, it creates a strong reference. When we set this reference to null,
     just like obj = null, then the instance that was created will still be there but counted as garbage and
     jvm will remove it eventually, we can suggest jvm to remove it using System.gc(); hence the space will be
     available for use again.

     BUT

     A good approach for objects which we eventually make null those are just to store cache so we should
     instead make them weak objects instead of strong objects, this programs demonstrates that.

*/

package OOP;

import java.lang.ref.WeakReference;

public class GarbageCollection {


    public static void main(String[] args) {
        // Demonstrating Garbage Collection - Strong reference.
        /*

        Employee e1 = new Employee("Alice" , 50000.0);
        System.out.println(e1);
        e1 = null; // this will be considered garbage "new Employee("Alice" , 50000.0)".
        System.out.println(e1);

         */


        // Now Demonstrating garbage collection using week reference
        WeakReference<Employee> e1 = new WeakReference<>(new Employee("Alice" , 50000.0));
        System.out.println(e1.get());
        System.gc();
        // now wait for 10 seconds
        simulateGCProcess();
        System.out.println(e1.get());

        /*
        * Expected Output Should Be:
            Employee{name='Alice', salary=50000.0}
            Collecting Garbage...
            null
        * */
    }

    public static void simulateGCProcess() {
        try {
            System.out.println("Collecting Garbage...");
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
