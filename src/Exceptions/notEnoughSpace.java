package Exceptions;

public class notEnoughSpace extends Exception {
    public notEnoughSpace() {
        super("Not Enough Space"); // recommended method
    }
//    @Override
//    public String toString() {
//        return "Not Enough Space";
//    }

}
