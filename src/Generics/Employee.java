package Generics;

public class Employee implements Comparable<Employee> {

    private int age;
    public void setAge(int age)
    {
        this.age = age;
    }
    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.age, o.age);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.setAge(60);
        e2.setAge(45);

        System.out.println(e2.compareTo(e1));
    }
}
