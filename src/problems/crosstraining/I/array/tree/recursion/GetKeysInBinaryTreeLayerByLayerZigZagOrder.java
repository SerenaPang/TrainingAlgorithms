package problems.crosstraining.I.array.tree.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    /**
     * the whole tree use bfs to expand and generate nodes to get all keys
     * even number level: use a queue to store the elements that are expand and generates,
     * the order of first in first out so we can get element in and out in zig order
     *
     * when print from the stack, it should be poll from the first element
     *
     * odd number level: when polling element from queue, we print in first in firts out order, and generates nodes will be put in to a stack
     * so that whatever first get in , will be the last to get out
     *
     *
     *
    */
        public List<Integer> zigZag(TreeNode root){
            //where we use it to store results
            List<Integer> result = new ArrayList<>();
            //where we use it as a queue and a stack to store and poll elements
            Deque<TreeNode> buffer = new ArrayDeque<>();
            int level = 0;
            buffer.offerFirst(root);
            while (!buffer.isEmpty()) {
                int numberOfNodesInOneLayer = buffer.size();
                for (int i = 0; i < numberOfNodesInOneLayer; i++) {
                    if (level % 2 == 0) {//at even layer, poll from right to left, but
                        // to prepared the next level print from right to left
                        TreeNode cur = buffer.pollLast();//poll is the order of printing
                        result.add(cur.key);
                        if (cur.right != null) {
                            buffer.offerFirst(cur.right);
                        }
                        if (cur.left != null) {
                            buffer.offerFirst(cur.left);
                        }
                    } else {//at odd layer, poll from left to right, but prepared
                        // the next level to print from left to right
                        TreeNode cur = buffer.pollFirst();
                        result.add(cur.key);
                        if (cur.left != null) {
                            buffer.offerLast(cur.left);
                        }
                        if (cur.right != null) {
                            buffer.offerLast(cur.right);
                        }
                    }
               }
                level++;
            }
            System.out.println("Level: " + level);
            return result;
        }

        public void print (List<Integer> result) {
            for (int i  = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        GetKeysInBinaryTreeLayerByLayerZigZagOrder gk = new GetKeysInBinaryTreeLayerByLayerZigZagOrder();
        List<Integer> result = gk.zigZag(a);
        gk.print(result);
    }

}
