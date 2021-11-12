package problems.recursionIII;

public class FlattenBinaryTreetoLinkedList {

    public TreeNode flatten(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        helper(root, pre);
        return root;
    }
    /***
     * process all the nodes in the left  subtree, convert it to a linke list with tail reference
     * process all nodes from the right subtree and convert it to a linked list with head reference
     *
     * connect the tail ffrom thte left subtree to the head of the right subtree
     *
     */

/**
 * @param pre is the previous node we want to connect with root (pre.right = root) 右倾树
 * @param root current node
 * */
    public void helper(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return;
        }
        System.out.println("root: " + root.key);

        helper(root.right, pre);
        helper(root.left, pre);
        //returns pre as the tail of the left subtree
        //when previous node is not null, the current node should connect with pre
        root.right = pre[0];
        //clear the left node
        root.left = null;
        pre[0] = root;
    }

    public void print(TreeNode root) {
        while (root != null) {
            System.out.print(root.key + " ");
            root = root.right;
        }
        System.out.println("Done");
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;

        FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
        TreeNode flatten = f.flatten(one);
        System.out.println("The flatten tree looks like: " );
        f.print(flatten);
    }
}
