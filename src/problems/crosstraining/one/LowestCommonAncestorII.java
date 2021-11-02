package problems.crosstraining.one;

public class LowestCommonAncestorII {
    // TC: O(n) SC:O(1)
    public TreeNodeP lca(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
        //if one node is another's parent node, then the parent node is the lowest common ancestor
        if (one.parent == two) {
            return two;
        }
        if (two.parent == one) {
            return one;
        }

        int lengthOne = length(one);
        int lengthTwo = length(two);

        int diff = Math.abs(lengthOne - lengthTwo);
        //we compare the length since in the findLCA function, it's going to trace up from the longer distance of the node
        if (lengthOne <= lengthTwo) {
            return findLCA(one, two, diff);
        } else {
            return findLCA(two, one, diff);
        }
    }

    /**
     *This functino is going to trace up the nodes to the same level, and goes up until it finds the common lca of the 2 nodes
     * */
    private TreeNodeP findLCA(TreeNodeP shorterDistanceNode, TreeNodeP longerDistanceNode, int diff){
        while (diff > 0) {
            longerDistanceNode = longerDistanceNode.parent;
            diff--;
        }
        while (longerDistanceNode != shorterDistanceNode) {
            longerDistanceNode = longerDistanceNode.parent;
            shorterDistanceNode = shorterDistanceNode.parent;
        }
        return longerDistanceNode;
    }

    /**
     * This function is going to get the length of the list(height) from the node to the root of the tree
     * using parent pointer
     * */
    private int length(TreeNodeP node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.parent;
        }
        return length;
    }

    public static void main(String[] args) {
        TreeNodeP a = new TreeNodeP(5, null);
        TreeNodeP b = new TreeNodeP(9, a);
        TreeNodeP c = new TreeNodeP(12, a);
        TreeNodeP d = new TreeNodeP(2,b);
        TreeNodeP e = new TreeNodeP(3, b);
        TreeNodeP f = new TreeNodeP(14, c);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        TreeNodeP firstNode = d;
        TreeNodeP secondNode = f;
        LowestCommonAncestorII lca = new LowestCommonAncestorII();
        TreeNodeP result = lca.lca(a, firstNode, secondNode);
        System.out.println("The lowest common ancester of " + firstNode.key +
                " and " + secondNode.key + " is " + result.key);

    }
}
