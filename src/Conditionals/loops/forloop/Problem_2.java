/*
Problem 2 — Reverse traversal
- Given an array: int[] nums = {10, 20, 30, 40, 50};
- Print elements in reverse order.

👉 Why enhanced for is NOT suitable here?
Answer: Because it iterates over the actual elements and moves in one direction from first element to last
element, so it is not possible to move from last to first element using enhanced for loop.
*/

package Conditionals.loops.forloop;

public class Problem_2 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }
}
