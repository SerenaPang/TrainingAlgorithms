package problems.warm.up.exercises.II;

import java.util.List;

public class ReverseLinkedListIterative {
    /**
     * reverse a linked list iteratively
     *      1->2->3->4->null
     *  pre
     *      cur
     *         cur.nxt
     *  cur.next = pre;
     *  pre = cur;
     *  cur = cur.next;
     *
     * TC: O(n)
     * SC: O(1)
     * */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode nxt = null;

        while (head != null) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;

        ReverseLinkedListIterative reve = new ReverseLinkedListIterative();
        reve.print(one);
       ListNode after =  reve.reverse(one);
        reve.print(after);
    }
}
