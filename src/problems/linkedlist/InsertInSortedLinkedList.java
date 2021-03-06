package problems.linkedlist;

public class InsertInSortedLinkedList {
    /**
     * TC: O(n)
     * SC: O(1)
     * 3 cases:
     * - insert at the head:
     *  creat a new head, and connect it with the old one, return the new head
     * - insert in the middle:
     *  find the node, which current node is smaller than the inserted node, and the next node is greater
     * - insert at the end:
     *
     * */
    public ListNode insert(ListNode head, int value) {
        // 1 3 5
        //insert at the beginning of the linked list
        if (value <= head.value) {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        ListNode cur = head;
        //insert in the middle of the linked list, include the case of appending at the end of the linked list
        //0 1  3 4  insert 2
        //     c
        //cur should stop at where it's greater than insert value, since we already store previous node
        //0 1 2 3 4 insert 5
        //        c
        //cur should stop at the nxt is null, and cur is still smaller than the insert value
        ListNode pre = null;
        while (cur != null && cur.value <= value) {
            pre = cur;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(value);
        ListNode nxt = pre.next;
        pre.next = newNode;
        newNode.next = nxt;
        return head;
    }

    //insert in the middle using cur.next
    public ListNode insertII(ListNode head, int value){
        ListNode cur = head;
        while (cur.next.value < value) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(value);
        //remember to store the next nodes so that we don't lost them
        ListNode nxt = cur.next;
        cur.next = newNode;
        newNode.next = nxt;
        return head;
    }

    //insert the node at the end of the linked list
    public ListNode insertAtTheEnd(ListNode head, int value) {
        //insert at the end of the linked list
        //0 1 2 3 4   insert 5
        //        c
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null && cur.value <= value) {
            //pre has to be placed before cur since it needs to record the current cur before it points to the next cur node
            pre = cur;
            cur = cur.next;
        }
        System.out.println("pre: " + pre.value);
        ListNode newNode = new ListNode(value);
        ListNode nxt = pre.next;
        pre.next = newNode;
        newNode.next = nxt;
        return head;
    }

    /***
     * print the linked list
     */
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
        //1 -> 3 -> 4 -> null
        one.next = three;
        three.next = four;

        //insert 0: 0 -> 1 -> 3 -> 4 -> null
        int value0 = 0;
        //insert 2: 0 -> 1 -> 2 -> 3 -> 4 -> null
        int value2 = 2;
        //insert 5: 0 1 2 3 4 5 null
        int value5 = 5;

        InsertInSortedLinkedList i = new InsertInSortedLinkedList();
        System.out.println("Original linked list: ");
        i.print(one);

        System.out.println("Insert 0: ");
        ListNode result = i.insert(one, value0);
        i.print(result);

        System.out.println("Insert 2: ");
        ListNode result1 = i.insert(one, value2);
        i.print(result1);

        System.out.println("Insert 5: ");
        ListNode result2 = i.insert(one, value5);
        i.print(result2);
    }
}
