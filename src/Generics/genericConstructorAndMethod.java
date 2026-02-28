package Generics;

class Box <T extends Integer> {
    private T number;

    public <U> Box (U number, Class<T> type) {
       if(type == Integer.class) {
           switch (number) {
               case Integer i -> this.number = type.cast(number);
               case Double v -> this.number = type.cast(number);
               default -> System.out.println("Invalid Value");
           }
       }
    }

    public T getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Box{" +
                "number=" + number +
                '}';
    }
}

class BoxUtil {
    public static <T extends Comparable<T>> int findMax(T b1, T b2) {
        return b1.compareTo(b2);
    }

}
public class genericConstructorAndMethod {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<Integer>(20, Integer.class);
        Box<Integer> b2 = new Box<Integer>(50, Integer.class);
        System.out.println(BoxUtil.findMax(b1.getNumber(),b2.getNumber()));
    }
}
