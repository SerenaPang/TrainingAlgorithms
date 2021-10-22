package problems.warm.up.exercises.I;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }

        if (root == one || root == two) {
            return root;
        }

        TreeNode loleft = lowestCommonAncestor(root.left, one, two);
        TreeNode loright = lowestCommonAncestor(root.right, one, two);
        if (loleft != null && loright != null) {
            return root;
        }
        if (loleft == null) {
            return loright;
        } else {
            return loleft;
        }
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(12);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(14);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

      //  lowestCommonAncestor(a, d, f);
        lowestCommonAncestor(a, d, b);
    }
}
