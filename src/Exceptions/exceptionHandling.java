package Exceptions;
// unchecked exceptions
class tryCatch {
    // example 1 (simple try, catch, multiple catch blocks
    public void example1(int[] numerator, int[] denomerator) {
        for(int i = 0; i < 6; i++) {
            try {
                System.out.println(numerator[i] / denomerator[i]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bound: " + e);
            } catch (ArithmeticException e) {
                System.out.println("Division By Zero Error: " + e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    // example 2, hierarchy, stackTrace
    public  void example2() {
        int[] arr = new int[5];
        arr[5] = 15;
    }
    public void fun1() {
        this.example2();
    }
    public void fun2() {
        this.fun1();
    }


}

public class exceptionHandling {
    public static void main(String[] args) {
//        int[] arr = {10,20,30,40};
//        int[] divider = {5, 10, 0, 10};
        tryCatch e1 = new tryCatch();
//        e1.example1(arr, divider);
        try {
            e1.fun2();
        } catch (Exception z) {
//            z.printStackTrace();;
            StackTraceElement[] elements = z.getStackTrace();
            for (int i = 0; i < elements.length; i++)
                System.out.println(elements[i]);
        }
    }
}
