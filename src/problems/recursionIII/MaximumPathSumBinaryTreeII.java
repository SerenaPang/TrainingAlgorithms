package problems.recursionIII;

public class MaximumPathSumBinaryTreeII {
    /**
     * find max path sum from any node to any node
     * */
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    /**
     * TC: O(n)
     * SC: O(h)
     * */
    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        //if one side is less than 0, we don't want it. if greater than 0, we will add it
        left = left < 0 ? 0: left;
        right = right < 0 ? 0 : right;
        //update max, we need to see if this path is greater than the curretn max
        max[0] = Math.max(max[0], left + right + root.key);
        //when we report to the upper level, we need to return a single path
        return Math.max(left, right) + root.key;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(-1);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(-14);

        one.left = two;
        one.right = eleven;
        eleven.left = six;
        eleven.right = fourteen;

        MaximumPathSumBinaryTreeII max = new MaximumPathSumBinaryTreeII();
        int maxPathSum = max.maxPathSum(one);
        System.out.println("The max path sum is: " + maxPathSum);
    }
}
