package Collections.List.Stacks;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); // it extends vector which means it can do what a vector + stack does

        // 1. PUSH (Insert elements)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack: " + stack);

        // 2. PEEK (Top element)
        System.out.println("Top element: " + stack.peek());

        // 3. POP (Remove top)
        System.out.println("Popped: " + stack.pop());

        // 4. SIZE
        System.out.println("Size: " + stack.size());

        // 5. isEmpty
        System.out.println("Is Empty: " + stack.isEmpty());

        // 6. SEARCH (1-based position from top)
        System.out.println("Position of 20: " + stack.search(20));

        // 7. ITERATE
        System.out.println("Stack elements:");
        for (int i : stack) {
            System.out.println(i);
        }

        // 8. CLEAR (Remove all)
        stack.clear();
        System.out.println("After clear: " + stack);
    }
}

