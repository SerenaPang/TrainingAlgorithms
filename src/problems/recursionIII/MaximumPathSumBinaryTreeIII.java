package problems.recursionIII;

public class MaximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    /**
     * we have to consider the possibities of:
     * left is bigger or right is bigger with the root
     * and keep updating the max value
     * */
    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        max[0] = Math.max(max[0], Math.max(left, right) + root.key);
        return Math.max(left, right) + root.key;
    }

    public int maxHelper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxHelper(root.left, max);
        int right = maxHelper(root.right, max);
        int sin = Math.max(Math.max(left, right), 0) + root.key;
        max[0] = Math.max(max[0], sin);
        return sin;
    }


    public static void main(String[] args) {
        TreeNode five = new TreeNode(-5);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode three = new TreeNode(-3);

        five.left = two;
        five.right = eleven;
        eleven.left = six;
        eleven.right = fourteen;
        fourteen.left = three;

        MaximumPathSumBinaryTreeIII sum = new MaximumPathSumBinaryTreeIII();
        int result = sum.maxPathSum(five);
        System.out.println("The max path sum is: " + result);

    }
}
