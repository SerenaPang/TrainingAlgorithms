package problems.linkedlist;

public class AddTwoNumbers {
    /**
     *  2 4 3
     *  5 6 4
     *  ------
     *
     *  243 + 564 = 807
     *  return 7 -> 0 -> 8
     *
     *  reverse both linked list:
     *   3 4 2
     *   4 6 5
     *   ------
     *   7 10 7
     *
     *   add the numbers and link each number together
     *   when sum is greater than 9, mod the number to get the carry, and set the result to be 0
     *
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode one = reverse(l1);
        ListNode two = reverse(l2);
        ListNode cur = dummy;

        int carry = 0;
        while (one != null && two != null) {

            int result = one.value + two.value;
          // System.out.println("result: " + result);
             carry = result % 10;
            System.out.println("carry: " + carry);
            ListNode res;
            if (carry >= 10) {
                res = new ListNode(0);
            } else {
                res = new ListNode(carry);
            }

            one = one.next;
            two = two.next;

        }

        return dummy.next;
    }

    /**
     * reverse linked list
     * 1 2 3 4
     *
     */
    public ListNode reverse(ListNode head) {
        ListNode nxt = null;
        ListNode pre = null;
        ListNode cur = head;
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
        //2 4 3
        ListNode twoa = new ListNode(2);
        ListNode foura = new ListNode(4);
        ListNode threea = new ListNode(3);
        //5 6 4
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode fourb = new ListNode(4);

        twoa.next = foura;
        foura.next = threea;

        five.next = six;
        six.next = fourb;

        AddTwoNumbers a = new AddTwoNumbers();
        a.print(twoa);
        a.print(five);
        System.out.println("adding these two numbers: ");
        ListNode result =  a.addTwoNumbers(twoa, five);
        a.print(result);

        System.out.println(10 %10
        );
    }
}
