package problems.warm.up.exercises.recursionIII;

public class MaximumPathSumBinaryTreeI {

    /**
     * possibilities:
     *
     * left max path sum
     * right max path sum
     * left + root + right max path sum
     * */
    public int maxPathSum(TreeNode root) {
        int max[] = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.key;
        }
        int leftPathSum = helper(root.left, max);
        int rightPathSum = helper(root.right, max);

        if (root.left != null && root.right != null) {
            //compare the current max with the sum of the path
            max[0] = Math.max(max[0], leftPathSum + rightPathSum + root.key);
            //we have to return the largest sum path to the upper level, so we can't
            //have path sum with both left and right node. we have to pick from left or from right
            return Math.max(leftPathSum, rightPathSum) + root.key;
        }
        //if one side is missin, we will return the non null side plus the root value to the upeer level
        return root.left == null ? rightPathSum +  root.key :  leftPathSum + root.key;
    }

    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(-15);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);

        fifteen.left = two;
        fifteen.right = eleven;
        eleven.left = six;
        eleven.right = fourteen;


    }
}
