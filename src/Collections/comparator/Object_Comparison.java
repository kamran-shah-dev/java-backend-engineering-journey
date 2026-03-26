package Collections.comparator;


import javax.xml.transform.Source;
import java.util.*;

class Employee {
    private String name;
    private int experienceY;

    public Employee(String name, int experienceY) {
        this.name = name;
        this.experienceY = experienceY;
    }

    public String getName() {
        return name;
    }

    public int getExperienceY() {
        return experienceY;
    }
}
public class Object_Comparison {
    public static void main(String[] args) {
        // Unlike Integer and Strings, we use different comparator logic for the object comparison

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Affan" , 6));
        employees.add(new Employee("Burkan" , 10));
        employees.add(new Employee("Afnan" , 5));
        employees.add(new Employee("Zadran" , 4));
        employees.add(new Employee("Adnan" , 4));
        employees.add(new Employee("Sufran" , 8));

        // employees.sort(null); // logical error, because in object we have two values, it cannot specify which value we choose

        // Method - 1: Lambda Expression
        /* employees.sort((n1, n2) -> {
            // this is ascending order sort.
            // to change the sort to descending order, just replace n1 with n2 and vice versa or
            // return 1 with return -1 and vice versa
            if(n1.getExperienceY() - n2.getExperienceY() > 0) {
                return 1;
            } else if (n1.getExperienceY() - n2.getExperienceY() < 0) {
                return - 1;
            } else {
                return n1.getName().compareTo(n2.getName());
            }
        });



        employees.sort((n1, n2) -> n1.getExperienceY() - n2.getExperienceY()); // in case we don't consider equal values.
         */

        // Method - 2: Using method chaining
        // Ascending order
        Comparator<Employee> comparator = Comparator.comparing(Employee::getExperienceY);
        employees.sort(comparator);
        for(Employee e : employees) {
            System.out.println(e.getName() + " : " + e.getExperienceY());
        }

        System.out.println("------------------------------------------");
        // Descending order
        Comparator<Employee> comparator2 = Comparator.comparing(Employee::getExperienceY).reversed();
        employees.sort(comparator2);
        for(Employee e : employees) {
            System.out.println(e.getName() + " : " + e.getExperienceY());
        }

        System.out.println("------------------------------------------");
        // Descending order / Ascending order - In case we have equal values
        // After thenComparing we can use reversed as well.
        Comparator<Employee> comparator3 = Comparator.comparing(Employee::getExperienceY).reversed().thenComparing(Employee::getName);
        employees.sort(comparator3);
        for(Employee e : employees) {
            System.out.println(e.getName() + " : " + e.getExperienceY());
        }

    }
}
