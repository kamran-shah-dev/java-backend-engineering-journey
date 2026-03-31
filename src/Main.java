import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Solution sl = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));


        ListNode temp = sl.addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val1 = 0,  val2 = 0, sum = 0;
            if (l1 != null) {val1 = l1.val; l1 = l1.next;}
            if (l2 != null) {val2 = l2.val; l2 = l2.next;}

            System.out.println("val1 " + val1 );
            System.out.println("val2 " + val2 );
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum, null);
            temp = temp.next;
        }
        temp.next = new ListNode(carry, null);
        return result;
    }
}