package data.structures.linkedlist.singly;
/**
 * Operations:
 *  - get length
 *  - get value in index
 *  - append value in the head of the linked list
 *  - append value in the tail of the linked list
 *  - remove the first matching element(head, middle, tail)
 * */
public class LinkedListOperations {
    /**
     * get length
     * */
    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * get the node at a specified index
     * return the node at index
     * */
    public ListNode get(ListNode head, int index) {
        int i = 0;
        while (head != null) {
            if (i == index) {
                return head;
            }
            i++;
            head = head.next;
        }
        return head;
    }

    /**
     * get the node at a specified index
     * return the node at index
     * */
    public ListNode getII(ListNode head, int index) {
        while (index > 0 && head != null) {
           while (index >  0 && head != null) {
                head = head.next;
                index--;
           }
        }
        return head;
    }

    /**
     * append value in the head of the linked list
     * */
    public void appendHead() {

    }
    /**
     *
     * */
    public void appendTail() {

    }
    /**
     *
     * */
    public void remove () {

    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        LinkedListOperations list = new LinkedListOperations();
        //length
        int len = list.length(one);
        System.out.println("Length: " + len);

        //get index
        //ListNode indexNode = list.get(one, 1);
        ListNode indexNode = list.getII(one, 1);
        System.out.println("Node at index 1 is "  + indexNode.value);


    }
}
