package Maps.HashMap;

import java.util.HashMap;
import java.util.Objects;

public class CustomClassAsKeyScenario {
    public static void main(String[] args) {

        /*
         * 🔹 Using Custom Class as Key in HashMap
         *
         * - In Java HashMap, keys are stored and retrieved using two important methods:
         *   hashCode() and equals().
         *
         * - For built-in data types like String and Integer, these methods are already
         *   properly implemented. However, for custom classes (like Student), we must
         *   override them manually.
         *
         * - By default, every object has a unique memory reference, and the default
         *   hashCode() is based on that memory location. This means:
         *     • Two objects with the same data are still treated as different keys
         *     • Duplicate key replacement will NOT happen
         *
         * - To solve this, we override hashCode() so that it generates a hash based on
         *   actual object data (e.g., name and rollNumber). This ensures:
         *     • Same data → same hashCode
         *     • Objects go to the same bucket in HashMap
         *
         * - We also override equals() to define logical equality between objects.
         *   In this case:
         *     • Names are compared (case-insensitive)
         *     • Roll numbers are compared
         *     • If both match → objects are considered equal
         *
         * - Important Rule:
         *     • If you override hashCode(), you MUST override equals()
         *     • Otherwise, HashMap behavior becomes inconsistent
         *
         * - In this example:
         *     • s1 and s3 have same name and rollNumber
         *     • hashCode() returns same value for both
         *     • equals() returns true
         *     • So s3 replaces the value of s1 in HashMap
         *
         * - Final Result:
         *     • Map size becomes 2 (not 3)
         *     • Value of s1 becomes "System Design" (replaced by s3)
         *
         * - Summary:
         *     • hashCode() → decides bucket location
         *     • equals() → checks if keys are logically equal
         *     • Both must be properly overridden for custom objects
         *
         * - Real-world analogy:
         *     • hashCode() = house address
         *     • equals() = identity of person in the house
         *     • Same address + same person → same key
         */

        HashMap<Student, String> enrollments = new HashMap<>();
        Student s1 = new Student("Kamran" , 100);
        Student s2 = new Student("Affan" , 101);
        Student s3 = new Student("Kamran" , 100);

        enrollments.put(s1, "DSA");
        enrollments.put(s2, "System Design");
        enrollments.put(s3, "System Design");

        System.out.println(enrollments.size());
        System.out.println(enrollments.get(s1));


    }
}

class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return name + " is enrolled in " + rollNumber + " ? ";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber); // generate hashcode based on the provided arguments
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Student otherStudent = (Student) obj;
        return Objects.equals(name.toUpperCase(), otherStudent.name.toUpperCase()) &&
                rollNumber == otherStudent.getRollNumber();
    }
}
