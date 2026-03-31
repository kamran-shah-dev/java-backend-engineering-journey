package Collections.comparator;

import java.util.ArrayList;
import java.util.List;

public class Comparables {
    public static void main(String[] args) {
        List<Employees> newList = new ArrayList<>();
        newList.add(new Employees("Kamran" , 50000));
        newList.add(new Employees("Adnan" , 30000));
        newList.add(new Employees("Affan" , 60000));

        newList.sort(null);
        System.out.println(newList);

    }
}


class Employees implements Comparable<Employees> {
    private String name;
    private int salary;

    public Employees(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employees o) {
        return o.getSalary() - this.getSalary();
    }
}