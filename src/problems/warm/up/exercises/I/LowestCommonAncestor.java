package problems.warm.up.exercises.I;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        System.out.println("curretly we are at root: " + root.value);

        //termination condition: when we reach the end of the tree, if at the end of the tree no noede was returned
        //that means we didn't found the node
        if (root == null) {
            return null;
        }
        //if the root is one of the target node, we will return the node to the function
        if (root == one || root == two) {
            System.out.println(root.value + " equals to pass in node " + one.value + " " + two.value);
            return root;
        }
        //left is asking the left subtree and right is asking the right subtree
        //we expect the left and right return the node tha's found
        TreeNode loleft = lowestCommonAncestor(root.left, one, two);
        System.out.println("left return: " + loleft.value);
        TreeNode loright = lowestCommonAncestor(root.right, one, two);
        System.out.println("right return: " + loright.value);
        //if left and right are not null, it means both nodes were found, so we return the node itself because both side are not null
        //then itself is the lca
        if (loleft != null && loright != null) {
            return root;
        }
        //if the left side is not the node we are looking for, but right side has return the node, then right is the node, we return r ight
        //if left side is the node, we return the node, so left is not null, but if right side is null, then we return left to the function that calls it
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

        lowestCommonAncestor(a, d, f); //2 14
       // lowestCommonAncestor(a, d, b);//2 9
    }
}
