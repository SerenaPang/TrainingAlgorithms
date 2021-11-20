package problems.warm.up.exercises.III;

public class MergeTwoSortedLinkedList {
    //TC: O(m + n) SC:O(1)
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (one != null && two != null) {
            System.out.println("one: " + one.value + " two: " + two.value);
            if (one.value < two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        //link remaining possible nodes
        if (one != null) {
            cur.next = one;
        }

        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList m = new MergeTwoSortedLinkedList();
        ListNode L1 = new ListNode(1);
        ListNode four = new ListNode(4);
        ListNode six = new ListNode(6);
        L1.next = four;
        four.next = six;

        ListNode L2 = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        L2.next = three;
        three.next = five;

        m.print(L1);
        m.print(L2);

        ListNode result = m.merge(L1, L2);
        m.print(result);
    }
}
