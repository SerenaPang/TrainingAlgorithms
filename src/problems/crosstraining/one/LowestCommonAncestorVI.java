package problems.crosstraining.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TC: O(n)
 * SC: O(h +k)
 * */
public class LowestCommonAncestorVI {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set){
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

        LowestCommonAncestorVI lca = new LowestCommonAncestorVI();
        List<TreeNode> listNodes = new ArrayList<>();
        listNodes.add(d);//2
        listNodes.add(e);//3
        listNodes.add(f);//14

       // listNodes.add();//9
        TreeNode result = lca.lowestCommonAncestor(a, listNodes);
        //TreeNode result = lca.lowestCommonAncestor(a, );
    }

}
