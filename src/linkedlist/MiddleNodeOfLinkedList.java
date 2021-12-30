package linkedlist;

public class MiddleNodeOfLinkedList {
    /**
     *  TC: O(n)
     *  SC: O(1)
     * slow and fast starts at the beginning of the linked list
     * slow walks 1 step, fast walks 2 steps, at the end slow will stops at the middle node of the linked list
     * - when it's even number linked list, fast should stop at fast.next.next == null
     * - when odd, fast should stop at fast.next == null
     *  1 -> 2 -> 3 -> 4 -> null
     *     slow
     *           fast
     *
     *  1 -> 2 -> 3 -> null
     *     slow
     *           fast
     * */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
      //  two.next = three;
       // three.next = four;

        MiddleNodeOfLinkedList m = new MiddleNodeOfLinkedList();
        System.out.println("The middle node is: " + m.middleNode(one).value);

    }
}
