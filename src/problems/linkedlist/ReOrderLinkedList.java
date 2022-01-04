package problems.linkedlist;

import java.util.List;

/**
 * reorder the linked list from
 * 1 2 3 4 5 6 7 8 to
 * 1 8 2 7 3 6 4 5
 *
 * cut the original linked list in half:
 * 1 2 3 4  |  5 6 7 8
 * reverse the second half:
 * 1 2 3 4 |  8 7 6 5
 * merge the two linked list(without comparing since we don't have to sorted it, won just need to reorder it)
 * 1 8 2 7 3 6 4 5
 *
 * TC: O(n) -> to find the mid-point: O(n) to reverse the second half iteratively: O(n), to merge: O(n)
 * SC: O(1)-> to find the mid-point: O(1) to reverse the second half iteratively: O(1); recursively: O(n) to merge: O(1)
 * */
public class ReOrderLinkedList {
    //1 2 3 4 5 6 7 8
    //      m
    public ListNode reorder(ListNode head) {
        //find the mid-point
        ListNode mid = findMid(head);
        System.out.println("mid : " + mid.value);

        //create second linkedlist which is the secons half of the linked list
        ListNode secondHalf = mid.next;
        //disconnect before mid, so that we have the first half and the second half
        mid.next = null;

        System.out.println("first list: " );
        print(head);
        System.out.println("second list: ");
        print(secondHalf);

        //reverse the second half
        ListNode two = reverseIteratively(secondHalf);
        System.out.println("reverse the second list: ");
        print(two);
        //merge two lists
        merge(head, two);
        return head;
    }

    //find the mid-point
    //1 2 3 4 5 6
    //    s
    //        f
    //1 2 3 4 5
    //    s
    //        f
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //odd and even
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //reverse the second half
    //      1 2 3 4 5 6
    // pre  c n
    //store next; cur points to pre; pre becomes cur; cur points to nxt; repeat
    public ListNode reverseIteratively(ListNode head) {
        ListNode pre = null;
        ListNode nxt = null;
        ListNode cur = head;
        //the last node needs to point to the previous node
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    //reverse recursively
    /**
     * go to the end of the list since the end is going to be the new head that we need to return
     * when popping from the all stack, each level we make the next point to the previous node
     * and disconnect the head node with the next node
     * 1 2 3 4 5 6
     *           newH
     *         h hN
     *
     *
     * */
    public ListNode reverseRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //merge two lists
    //1 2 3
    //  p
    //4 5 6
    //p
    //0 1 2
    //    dp n
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode oneP = one;
        ListNode twoP = two;
        ListNode dummyP = dummy;
        //we don't have to disconnect what's after oneP or twoP since evrytime we enter the loop we might
        //set it to null again
        while (oneP != null && twoP != null) {
            //connect first linked list
            dummyP.next = oneP;
            dummyP = dummyP.next;
            oneP = oneP.next;
            //connect second linked list
            dummyP.next = twoP;
            dummyP = dummyP.next;
            twoP = twoP.next;
        }
        return dummy.next;
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
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);

        //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
/**
        System.out.println("The mid point is: " + r.findMid(one).value);
        //System.out.println("reverse linked list iteratively: ");
        //r.print(r.reverseIteratively(one));
        System.out.println("reverse linked list recursively: ");
        r.print(r.reverseRecursively(one));

        ListNode oneb = new ListNode(1);
        ListNode twob = new ListNode(2);
        ListNode threeb = new ListNode(3);
        ListNode fourb = new ListNode(4);
        ListNode fiveb = new ListNode(5);
        ListNode sixb = new ListNode(6);

        //1 2 3 null
        oneb.next = twob;
        twob.next = threeb;

        //4 5 6 null
        fourb.next = fiveb;
        fiveb.next = sixb;

        r.print(oneb);
        r.print(fourb);
        r.print(r.merge(oneb, fourb));
 */
        ReOrderLinkedList r = new ReOrderLinkedList();
        r.print(one);
        ListNode result = r.reorder(one);
        System.out.println("Reordering linked list: ");
        r.print(result);
    }
}
