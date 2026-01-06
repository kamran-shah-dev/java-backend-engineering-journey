/*
Problem 1 — Counting with intent
- Print numbers 1 to 100, but:
- Skip multiples of 3
- Stop completely when number reaches 50

👉 Questions to answer:
- Which loop?
- Why continue?
- Why break?
*/


package Conditionals.loops.forloop;

public class Problem_1 {
    public static void main(String[] args) {

        // using while loop
        int i = 1;
        while (i < 50) {
            if(i % 3 == 0) {
                i++;
                continue;
            }
            System.out.print(i + " ");
            i++;
        }

        // using for loop (senior level)
        for(int j = 0; j < 50; j++) {
            if(j % 3 == 0) continue;
            System.out.print(j + " ");
        }
    }
}
