package problems.linkedlist;

public class CheckIfLinkedListHasACycle {
    /**
     * slow and fast starts at the beginning of the linked list
     * slow walks 1 step, fast walks 2 steps
     * eventually slow will meet with fast if there is a cycle in the linked list
     * TC: O(n)
     * SC: O(1)
     * */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next.next != null) {
           //can not check if value equals here since both slow and fast are point to head at the beginning of the loop
            slow = slow.next;
            fast = fast.next.next;
            if (slow.value == fast.value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = head;

        CheckIfLinkedListHasACycle c = new CheckIfLinkedListHasACycle();
        if (c.hasCycle(head)) {
            System.out.println("There is a cycle in the linked list");
        } else {
            System.out.println("There are no cycle in the linked list");
        }
    }
}
