package problems.crosstraining.one;

import java.util.ArrayList;
import java.util.List;

public class ClosestNumberInBinarySearchTreeII {
    /**
     * This function finds the closest k number of nodes to the target
     * using binary search
     *
     * when we have the number that's closest to the target, we can expand from both direction
     * to get k number of nodes that are close to the target
     * */
    public int[] closestKValues(TreeNode root, double target, int k) {
        int[] result = new int[k];

        return result;
    }

    /**
     * This function finds the largest number smaller than the target
     * */

    /**
     * This function converts the list of nodes to an array of integer so it's easier to apply binary search
     * on the serialized tree
     * */
    public int[] serializedTree(TreeNode root) {
        List<Integer> treeAsList = new ArrayList<>();
        InOrderTraversal(root, treeAsList);

        int[] result = new int[treeAsList.size()];
        for (int i = 0; i < treeAsList.size(); i++) {
            result[i] = treeAsList.get(i);
        }
        return result;
    }

    /**
     * This function use in order traversal to get the tree node values in a list in ascending order
     * */
    public void InOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, result);
        result.add(root.key);
        InOrderTraversal(root.right, result);
    }

}
