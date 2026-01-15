package OOP.Class_and_Objects;

class initializer_block {
    public static int age;
    public float height;
    static {
        age = 10;
        System.out.println(age);
    }

    {
        height = 6.1f;
        System.out.println(age);
        System.out.println(height);
    }

}
public class class_abd_objects {
    public static void main(String[] args) {
        initializer_block ib = new initializer_block();
    }
}
