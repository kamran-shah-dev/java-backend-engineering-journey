package Generics;
interface ContainerTest<T> {
     void set(T t);
     T get ();
}

public class Container implements ContainerTest<String> {

    private String name;
    @Override
    public void set(String s) {
        this.name = s;
    }

    @Override
    public String get() {
        return name;
    }


    public static void main(String[] args) {
        Container c = new Container();
        c.set("Alpha");
        System.out.println(c.get());
    }
}
