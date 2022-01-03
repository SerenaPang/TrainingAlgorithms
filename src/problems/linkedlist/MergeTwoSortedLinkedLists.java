package problems.linkedlist;

public class MergeTwoSortedLinkedLists {
    /***
     * merging 2 linkedlist into 1 large linked list in ascending order
     * TC: O(n + m)
     * SC: O(1)
     *
     *  1 4 6
     *  o
     *  2 5
     *  t
     *
     *  compare the nodes in the 2 lists and connect the ones following the dummy node
     *
     */
    public ListNode merge(ListNode one, ListNode two) {
        //since we don't know which node in the two list is going to be
        ListNode dummy = new ListNode(0);
        ListNode oneP = one;
        ListNode twoP = two;
        //if we don't use this pointer to walk the linked list, then dummy.next will not be the fist node of the new large
        // linked list, it will be the next node of where it walks to
        ListNode dummyP = dummy;
        while (oneP!= null && twoP != null) {
            if (oneP.value <= twoP.value) {
                dummyP.next = oneP;
                oneP = oneP.next;
            } else {
                dummyP.next = twoP;
                twoP = twoP.next;
            }
            dummyP = dummyP.next;
        }
        //post proccesing nodes, since it's a sorted linked list, we don't have to connect one by one
        if (oneP != null) {
            dummyP.next = oneP;
        }

        if (twoP != null) {
            dummyP.next = twoP;
        }
        return dummy.next;
    }

    //print linked list
    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode four = new ListNode(4);
        ListNode six = new ListNode(6);
        //1->4->6->null
        one.next = four;
        four.next = six;
        //2->5->null
        ListNode two = new ListNode(2);
        ListNode five = new ListNode(5);
        two.next = five;

        MergeTwoSortedLinkedLists m = new MergeTwoSortedLinkedLists();
        ListNode result = m.merge(one, two);
        m.print(one);
        m.print(two);
        m.print(result);
    }
}
