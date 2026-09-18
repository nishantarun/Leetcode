/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = 0, val2 = 0;
            if (l1 != null)
                val1 = l1.val;
            if (l2 != null)
                val2 = l2.val;

            int currSum = val1 + val2 + carry;
            int unitDigit = currSum % 10;
            node.next = new ListNode(unitDigit);
            node = node.next;

            carry = currSum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return head.next;
    }
}