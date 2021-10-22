package problems.warm.up.exercises.I;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GeyKeysInBinaryTreeLayerByLayer {
    public static List<List<Integer>> layerByLayer(TreeNode root) {
        return helper(root);
    }

    public static List<List<Integer>> helper(TreeNode root ){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> aLevelOfNodes = new ArrayList<>();
            //number of nodes in the current level
            int size = queue.size();

            //expand the tree by the nodes in the queue for each level
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                //and add it to the result
                aLevelOfNodes.add(cur.value);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(aLevelOfNodes);
        }
        return result;
    }

    public static void print(List<List<Integer>> result) {
        for (List<Integer> aList : result) {
            System.out.print("[");
            for (int i = 0; i < aList.size(); i++) {
                System.out.print(aList.get(i) + " ");
            }
            System.out.print("]");
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

        List<List<Integer>> result = layerByLayer(a);
        print(result);
    }

}
