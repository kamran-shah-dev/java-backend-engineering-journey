package OOP.Object_class;

import javax.swing.plaf.IconUIResource;

class ObjectClass implements Cloneable {
    private String villian;
    private String movie;
    private int year;

    public ObjectClass(String villian, String movie, int year) {
        this.villian = villian;
        this.movie = movie;
        this.year = year;
    }

    public String getVillian() {
        return villian;
    }
    public String getMovie() {
        return movie;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return villian + " Was Villian in " + movie +" which was released in " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ObjectClass))
            return false;
        ObjectClass next = (ObjectClass) obj;
        return this.villian.equals(next.getVillian()) && this.movie.equals(next.getMovie())
                && this.year == next.year;
    }

    @Override
    public int hashCode() {
        int hash = 15;
        hash = 2 * hash + villian.hashCode();
        hash = 2 * hash + movie.hashCode();
        hash = 2 * hash + year;
        return hash;
    }

    @Override
    public ObjectClass clone() {
        try {
            return (ObjectClass) super.clone();
        } catch(CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
public class Object_class_Methods {
    public static void main(String[] args) {
        ObjectClass villian1 = new ObjectClass("John Abraham", "Zinda", 2015);
        ObjectClass villian2 = villian1.clone();

        System.out.println(villian2.equals(villian1));
        System.out.println(villian1.hashCode() == villian2.hashCode());

        System.out.println(villian2);
    }
}
