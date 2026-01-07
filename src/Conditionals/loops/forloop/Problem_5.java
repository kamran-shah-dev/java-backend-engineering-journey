/*
Problem 6 — Early exit optimization
You have a list of user IDs. Check whether any ID is banned.

👉 Rules:
- Stop checking once found
- Do NOT scan entire list unnecessarily

👉 Question:
Why is break a performance decision?
*/

package Conditionals.loops.forloop;

public class Problem_5 {
    public static void main(String[] args) {
        int[] userIds = {
                1023, 1456, 1789, 2034,
                2567, 3001, -999, 4120,
                4890, 5123, 6789, 7002,
                8450, 9123, 10001
        };


        for (int i: userIds)
        {
            if(i < 0) {
                System.out.println("Banned User Found with Id: " + i);
                break;
            }
        }
    }
}
