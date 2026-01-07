/*
Problem 4 — Filtering data (very common)
- Given a list of integers:
- Ignore negative numbers
- Print only even numbers
- Stop after printing 5 valid numbers

👉 Must use:
- continue
- break

👉 Ask yourself:
- Where should filtering happen?
- Is this readable?
*/

package Conditionals.loops.forloop;

public class Problem_3 {
    public static void main(String[] args) {
        int[] list = {
                -10, 3, 4, -7, 8,
                15, 22, -1, 6, 9,
                12, -5, 14, 17, -20,
                18, 21, 24, -3, 30
        };

        int validCount = 0;
        for(int i:list) {
            if (i <= 0) continue;
            if(i % 2 != 0 ) continue;

            System.out.print(i + " ");
            validCount++;

            if (validCount == 5) break;
        }
    }
}
