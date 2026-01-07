/*
Problem 3 — Input-driven loop (backend-style)
- Simulate reading user input until user enters "exit".

👉 Requirements:
- Loop must run at least once
- Must terminate safely
- No infinite loop

👉 Which loop fits best and why?
 */

package Conditionals.loops.dowhile_loop;

import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String input;
        int wordCount = -1;
        do {
            System.out.print("Enter a word or 'exit': ");
            input = userInput.nextLine();
            wordCount++;
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("You entered " + wordCount + " words");
    }
}
