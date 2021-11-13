package problems.warm.up.exercises.II;

import java.util.ArrayList;
import java.util.List;

public class SearchInBinarySearchTree {
    /**
     * Recursive Solution
     * TC: Balance BST O(logn), worst case O(n)
     * SC: O(height)
     * */
    public TreeNode search(TreeNode root, int target) {
        if (root.key == target) {
            return root;
        }
       return search(target < root.key ? root.left : root.right, target);
    }

    /**
     * Iterative Solution
     * TC: Balance BST O(logn), worst case O(n)
     * SC: O(1)
     * */
    public TreeNode searchIteratively(TreeNode root, int target) {
       TreeNode cur = root;
       while (cur != null && cur.key != target) {
           if (target < cur.key) {
               cur = cur.left;
           } else {
               cur = cur.right;
           }
       //or use ternary operator: cur = target < cur.key ? cur.left : cur.right;
       }
       return cur;
    }
    /**
     * in order traversal
     * */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    /**
     * [left] [root] [right]
     * */
    public void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.key);
        helper(root.right, result);
    }

    public void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode eleven = new TreeNode(11);
        TreeNode one= new TreeNode(1);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);
        TreeNode thirdteen = new TreeNode(13);

        seven.left = three;
        seven.right = eleven;
        three.left = one;
        three.right = five;
        eleven.left = nine;
        eleven.right = thirdteen;

        int target = 9;
        SearchInBinarySearchTree s = new SearchInBinarySearchTree();

        TreeNode result = s.searchIteratively(seven, 9);
        System.out.println( "Finding target " + target);
        System.out.println("Found target " + result.key);

        // List<Integer> tree = s.inOrder(seven);
       // s.print(tree);
    }

}
