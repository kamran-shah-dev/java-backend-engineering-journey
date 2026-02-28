package Exceptions;
// Note Excpetions cannot be generic because on runtime type erasure happens and the actual object is returned,
// so in that case we cannot make excpetions generic because exceptions are alreay thrown on runtime
public class genericAndException {
    public static void main(String[] args) {
        try {
            throw new excpt("Checking ");
        } catch (excpt e) {
            System.out.println(e);
        }
    }
}

// we can make method of an exception class (constructor or method)
class excpt extends Exception {
    public <T> excpt (T value) {
        super("Unwanted Exception: " +
                value +
                " " + value.getClass().getName());
    }

}