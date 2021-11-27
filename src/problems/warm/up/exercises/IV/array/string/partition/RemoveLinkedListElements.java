package problems.warm.up.exercises.IV.array.string.partition;

public class RemoveLinkedListElements {
    /***
     * 6 6 1 1 1 2 2 6 3 4 5 6
     */
    public ListNode removeElements(ListNode head, int target) {
        ListNode newHead = null;
        //if target node is the head of the list, we will remove all target nodes
        if (head.value == target) {
            while (head.value == target && head.next != null) {
                head = head.next;
            }
            newHead = head;
        }
        //link the nodes on the side of the target node
        ListNode cur = newHead;
        //remove the target node in the body, and the tail node if it's the target
        while (cur != null && cur.next != null) {
          if (cur.next.value == target) {
              cur.next = cur.next.next;
          }
          cur = cur.next;
        }
        return newHead;
    }

    public void print(ListNode head) {
        while (head!= null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode onea = new ListNode(1);
        ListNode oneb = new ListNode(1);
        ListNode onec = new ListNode(1);

        ListNode twoa = new ListNode(2);
        ListNode twob = new ListNode(2);

        ListNode threea = new ListNode(3);
        ListNode foura = new ListNode(4);
        ListNode fivea = new ListNode(5);

        ListNode sixa = new ListNode(6);
        ListNode sixb= new ListNode(6);
        ListNode sixc= new ListNode(6);
        ListNode sixd= new ListNode(6);
        //6 6 1 1 1 2 2 6 3 4 5 6
        sixa.next = sixb;
        sixb.next = onea;
        onea.next = oneb;
        oneb.next = onec;
        onec.next = twoa;
        twoa.next = twob;
        twob.next = sixc;
        sixc.next = threea;
        threea.next = foura;
        foura.next = fivea;
        fivea.next = sixd;

        RemoveLinkedListElements r= new RemoveLinkedListElements();
        System.out.println("Original List: ");
        r.print(sixa);
        int target = 6;
        //function should return: 1 1 1 2 2 3 4 5
        System.out.println("Remove target " + target);
        ListNode result = r.removeElements(sixa, target);
        r.print(result);
    }
}
