package problems.recursionIII;

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        int[] index = new int[]{post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }
    /**
     * @param postorder sequence
     * @param index index in sequence start from the end
     * @param min root value used for determine the boundary of left/rigth subtree
     * */
    public TreeNode helper(int[] postorder,  int[] index, int min) {
        if (index[0] < 0 || postorder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index[0]--]);
        root.right = helper(postorder, index, root.key);
        //since it's a binary search tree, the smallest number is in the leftmost corner of the tree
        root.left = helper(postorder, index, min);
        return root;
    }
}
