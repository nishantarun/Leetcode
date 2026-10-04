class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middleNode = divideList(head);
        ListNode secondHead = reverseList(middleNode);
        mergeList(head, secondHead);
    }

    public ListNode divideList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        return secondHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public void mergeList(ListNode head1, ListNode head2) {
        ListNode node1 = head1;
        ListNode node2 = head2;

        while (node2 != null) {
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;

            node1.next = node2;
            node2.next = next1;

            node1 = next1;
            node2 = next2;
        }
    }
}