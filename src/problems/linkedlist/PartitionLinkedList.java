package problems.linkedlist;

public class PartitionLinkedList {
    /**
     * put everything less than target to the left of the list
     * put everything larger than target to the right of the list
     * TC: O(n)
     * SC: O(1)
     *  target: 3
     *  2 4 3 5 1
     *  c
     * small:
     * 2 3 ...(even we have the value link to the rest of the nodes, we overwrite it everytime we connect  witht he next smaller node)
     * until we finish building the smaller list, then we linke it to the large list
     * large:
     * 4 5 1.. notice that here the large pointer has to unlink with 1
     * */
    public ListNode partition(ListNode head, int target) {
        ListNode smallerList = new ListNode(0);
        ListNode biggerList = new ListNode(0);
        ListNode curSmall = smallerList;
        ListNode curLarge = biggerList;
        //put all the smaller than target to smaller list and larger than target to larger list
        while (head != null) {
            if (head.value <= target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        //connect smaller end to larger head
        curSmall.next = biggerList.next;
        //unlink the last node in large partition
        curLarge.next = null;
        return smallerList.next;
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

        PartitionLinkedList p = new PartitionLinkedList();
        p.print(two);
        System.out.println("partitioning linked list: ");
        int target = 3;
        ListNode result = p.partition(two, target);
        p.print(result);
    }
}
