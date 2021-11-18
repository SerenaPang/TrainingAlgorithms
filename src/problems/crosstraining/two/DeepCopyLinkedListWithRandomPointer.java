package problems.crosstraining.two;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListWithRandomPointer {
    /**
     * Create a lookup map to avoid copy mutiple times for the same node
     * key: original value value: copied node
     * */
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //sentinel node to help construct the deep copy
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;

        //maintains the mapping between the node in the original list and the corresponding node in the new list
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            //copy the curretn node if necessary
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            //connect the copied node to the deep copy list
            cur.next = map.get(head);
            //copy the random node if necessary
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                   map.put(head.random, new RandomListNode(head.random.value));
                }
                //connect the copied node to the random pointer
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
