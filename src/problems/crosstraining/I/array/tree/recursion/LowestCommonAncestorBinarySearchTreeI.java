package problems.crosstraining.I.array.tree.recursion;

public class LowestCommonAncestorBinarySearchTreeI {
/**
 * TC: avg O(logn), worst O(n)
 * SC: O(1)
 *
 * This function checks if the root node is the lca of the 2 numbers
 * if  the smaller node is in the left and the larger node is in the right of the root node
 * then we return the root node as the lca
 *
 * if the root node is greater than the 2 nodes, we know that the nodes must be in the left side
 * so we go to the left subtree search for lca with the sme process; and vice versa
 *
 * */
    public TreeNode lca(TreeNode root, int firstNode, int secondNode) {
        int small = Math.min(firstNode, secondNode);//1
        int large = Math.max(firstNode, secondNode);//3
        while (root != null) {
            if (root.key < small) {
                root = root.right;
            } else if (root.key > large) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(12);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(14);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        int firstNode = d.key;
       // int secondNode = f.key;
        int secondNode = e.key;
        LowestCommonAncestorBinarySearchTreeI lwa = new LowestCommonAncestorBinarySearchTreeI();
        TreeNode result = lwa.lca(a, firstNode, secondNode);
        System.out.println("The lowest common ancester of " + firstNode +
                " and " + secondNode + " is " + result.key);
    }
}
