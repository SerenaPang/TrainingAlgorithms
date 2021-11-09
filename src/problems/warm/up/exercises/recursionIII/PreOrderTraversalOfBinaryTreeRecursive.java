package problems.warm.up.exercises.recursionIII;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalOfBinaryTreeRecursive {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper (TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.key);
        helper(root.left, result);
        helper(root.right, result);
    }

    public void print(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        PreOrderTraversalOfBinaryTreeRecursive pre = new PreOrderTraversalOfBinaryTreeRecursive();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        one.right = three;
        three.left = four;

        List<Integer> result = pre.preOrder(one);
        pre.print(result);
    }
}
