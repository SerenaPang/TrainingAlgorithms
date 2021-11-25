package problems.crosstraining.I.array.tree.recursion;

public class LowestCommonAncestorV {
    /**
     * find LCA in a Knary tree for 2 nodes passed in the function
     * TC: O(n)
     * SC: O(h)
     * */
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        //base case
        if (root == null || root == a || root == b) {
            return root;
        }
        //case 1: if all of them are null, return null
        //case 2: if only one of them is not null, return the non - null node
        //case 3: if more than one of them are not null, return root
        KnaryTreeNode foundResult = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode subResultNode = lowestCommonAncestor(child, a, b);
            if (subResultNode == null) {
                continue;
            }
            if (foundResult == null) {
                foundResult = subResultNode;
            } else {
                return root;
            }
        }
        return foundResult;
    }
}
