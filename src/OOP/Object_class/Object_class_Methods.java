package OOP.Object_class;

import javax.swing.plaf.IconUIResource;

class ObjectClass implements Cloneable {
    private String author;
    private String Book;
    private int year;

    public ObjectClass(String a, String b, int y) {
        this.author = a;
        this.Book = b;
        this.year = y;
    }

    @Override
    public String toString() {
        return author + " Published " + Book + " In " + year;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof ObjectClass))
            return false;
        ObjectClass b2 = (ObjectClass) o;
        return this.author.equals(b2.getAuthor()) && this.Book.equals(b2.Book)
                && this.year == b2.year;
    }

    public String getAuthor() {
        return author;
    }

    public String getBook() {
        return Book;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int hashCode() {
        int hash = 12;
        hash = 3 * hash * author.hashCode();
        hash = 3 * hash * Book.hashCode();
        hash = 3 * hash * year;
        return hash;
    }

    @Override
    public ObjectClass clone() {
        try {
            return (ObjectClass)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
public class Object_class_Methods {
    public static void main(String[] args) {
        ObjectClass obj = new ObjectClass("Kamran Shah" , "The Ultimate Jav" , 2016);
        ObjectClass obj1 = obj.clone();
        System.out.println(obj1);

        System.out.println("We Say obj and obj1 are euql: " + obj1.equals(obj));
        System.out.println("They have the same hash codd see: ");
        System.out.println();
    }
}
