package problems.warm.up.exercises.recursionIII;

public class CheckIfBinaryTreeIsBalanced {

    public boolean isBalanced(TreeNode root) {
        //termination condition, for each level we have to check the height
        if (root == null) {
            return true;
        }
        //for each level or the curretn level, we have to ask the height of the curretn level
        //we expect the left and right return the height and we compare if in this level, the tree is balanced
        //if in any level we detect the tree is not balance, we can immediately return false
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        //This call the function itself again to pass in the left of the subtree as root
        //and the right subtree as root so that they can check there subtrees as well
       return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
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

        CheckIfBinaryTreeIsBalanced cb = new CheckIfBinaryTreeIsBalanced();
        int height = cb.getHeight(a);
        System.out.println("The height of the tree is " + height);
        boolean balanced = cb.isBalanced(a);
        if (balanced) {
            System.out.println("This tree is balance");
        } else {
            System.out.println("This tree is not balance");
        }
    }
}
