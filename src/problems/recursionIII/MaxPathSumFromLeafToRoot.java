package problems.recursionIII;

public class MaxPathSumFromLeafToRoot {
    /**
     * find max path sum from a leaf to root
     * TC: O(n)
     * SC: O(n)
     * */
    public int maxPathSumToRoot(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    /**
     * helper function to take the larger side and return it to the upper level
     * */
    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0: left;
        right = right < 0 ? 0: right;

        int larger = Math.max(left, right);
        max[0] = Math.max(max[0], larger + root.key);
        return Math.max(left, right) + root.key;
    }

    /**
     * Solution 2: bottom up return the max suffix sum
     * */
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.key;
        }
        if (root.left == null) {
            return maxPathSum(root.right) + root.key;
        }
        if (root.right == null) {
            return maxPathSum(root.left) + root.key;
        }
        return root.key + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }


    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode two = new TreeNode(-2);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode four = new TreeNode(-4);

        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);

        ten.left = two;
        ten.right = seven;
        two.left = eight;
        two.right = four;

        seven.left = one;
        seven.right = three;

        MaxPathSumFromLeafToRoot max = new MaxPathSumFromLeafToRoot();
        System.out.println("The max path sum from a leaf to root is: " + max.maxPathSumToRoot(ten));
    }
}
