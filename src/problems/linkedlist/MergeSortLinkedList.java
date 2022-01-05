package problems.linkedlist;

public class MergeSortLinkedList {
    /**
     *  2 -> 4 -> 3 -> 5 -> 1 -> null
     * TC:  find mid-point: O(n) compare and merge: O(n)
     * SC: O()
     * mergesort algorithm:
     * 1. split the linked list until it can't be split any more
     *      2 4 3 5 1
     *      2 4 | 3 5 1
     *      2 | 4      3 | 5 1
     *      2 | 4      3 |   5 | 1
     *      find mid-point of the linked list and disconnect nodes after mid, so that we have two halves, and continue spliting
     *   every node is its own list
     *
     * 2. compare nodes to rearrange the order
     *    2 4
     *    merge two linked list
     * 3. return the head of the sorted linked list
     *   - need dummy node since we don't know which node is going to be the head of the result linked list
     *
     * */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        //unlink second half
        mid.next = null;
        //call function itself so that we split the linkedlist recursively
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(secondHalf);
        //return the sorted linkedlist by ordered merged
        return merge(left, right);
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);

        return dummy.next;
    }

    //find middle node
    //1 2 3 4 5 6
    //    s
    //        f
    //f.n.n == null
    //1 2 3 4 5
    //    s
    //        f
    //f.n == null
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);

        //2 -> 4 -> 3 -> 5 -> 1 -> null
        two.next = four;
        four.next = three;
        three.next = five;
        five.next = one;

        MergeSortLinkedList m = new MergeSortLinkedList();
        m.mergeSort(two);
    }
}
