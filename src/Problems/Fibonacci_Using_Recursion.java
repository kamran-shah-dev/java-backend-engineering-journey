package Problems;

public class Fibonacci_Using_Recursion {
    public static void Fibonacci(int f, int s, int n) {
        if(n == 0)
            return;
        if(s <= n) {
            System.out.print(f + " , ");
            int next = f + s;
            Fibonacci(s, next, n);
        } else System.out.println(f + " ");
    }

    public static void main(String[] args) {
        Fibonacci(0,1,3);
    }
}
