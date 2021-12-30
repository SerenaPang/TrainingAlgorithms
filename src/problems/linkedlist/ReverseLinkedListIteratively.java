package problems.linkedlist;

public class ReverseLinkedListIteratively {
    /**
     *  store the next node, so we don't lose it for next iteration
     *  make current node points to previous node
     *  current node becomes previous node
     *  repeat until head is null
     *
     *      0 -> 1 -> 2 -> 3 -> null
     * pre  cur  nxt
     *
     *  TC: O(n)
     *  SC: O(1)
     * */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = null;
        //when we arrived to the last node, we still have to make it points to the previous node
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
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

        ReverseLinkedListIteratively r = new ReverseLinkedListIteratively();
        r.print(head);
        System.out.println("After reversed: ");
        r.print(r.reverse(head));
    }
}
