package problems.linkedlist;

public class ReverseLinkedListRecursively {
    /**
     *  0 -> 1 -> 2 -> 3 -> null
     *  h
     *
     * for every recursion function call in the call stack, we keep head and head.next
     * we go to the end of the linked list, find the new head
     * pop the function call from the stack while making the head.next points to the head node,
     * and disconnect the head node points to the head.next node to reverse the pair
     *
     *  for every level, we do the same thing until all the function calls are popo off from the stack
     *
     * TC: O(n)
     * SC: O(n)
     *
     * */
    private ListNode reverse(ListNode head) {
        if (head.next != null) {
            System.out.println("head" + head.value);
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * print the linked list
     * */
    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = one;
        one.next = two;
        two.next = three;

        ReverseLinkedListRecursively r = new ReverseLinkedListRecursively();
         //r.print(head);
        //System.out.println("After reversed: ");
        r.reverse(head);
        //r.print(r.reverse(head));
    }
}
