package problems.crosstraining.one;

public class LowestCommonAncestorII {
    public TreeNodeP lca(TreeNodeP root, TreeNodeP one, TreeNodeP two) {

        return null;
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
        System.out.println("The lowest common ancester of " + firstNode +
                " and " + secondNode + " is " + result.key);

    }
}
