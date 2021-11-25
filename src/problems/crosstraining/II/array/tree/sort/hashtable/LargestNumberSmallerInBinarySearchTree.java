package problems.crosstraining.II.array.tree.sort.hashtable;

import problems.crosstraining.I.array.tree.recursion.TreeNode;

/**
 * TC: avg O(logn), worst case: O(n)
 * SC: O(1)
 * */
public class LargestNumberSmallerInBinarySearchTree {

    public int largestSmallerThanTarget(TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {// we don't want larger than target
                root = root.left;
            } else {//we want smaller than target, so the candidates are all the nodes in this path of searching for target
                //Notice: that the later searched node has larger value than the earlier searched nodes, so we want to return it immediately
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }
}
