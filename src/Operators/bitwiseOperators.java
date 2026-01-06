package Operators;

public class bitwiseOperators {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;

        // to find binary of integer
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        // & , | , ^ and ! operators
        System.out.println("5 & 2 = " + (a & b));
        System.out.println("5 | 2 = " + (a | b));
        System.out.println("5 ^ 2 = " + (a ^ b));
        System.out.println("~5 = " + (~5));

        // right shift and left shift (>> , <<)
        System.out.println("5 >> b = " + (a >> b) ); // right shift binary of a up-to b bits

        System.out.println("5 << b = " + (a << b) ); // left shift binary of a up-to b bits
        System.out.println(Integer.toBinaryString(a << b));
    }
}
