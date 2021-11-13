package problems.warm.up.exercises.II;

public class DeleteInBinarySearchTree {
    /**
     * This function delete a node in BST, and maintained the property of the BST
     * */
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root.key == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left != null && root.right != null) {
                if (root.right.left == null) { //the first node is the smallesst larger than target
                    //it will take over the root's left child
                    TreeNode newRoot = root.right;
                    root.right.left = root.left;
                    return newRoot;
                } else { //but if right child has left subtree, we have to find succesor from it
                    TreeNode newRoot = FindSuccessor(root.right);
                    //successor will take over the children of the root
                    newRoot.left = root.left;
                    newRoot.right = root.right;
                    return newRoot;
                }
            }
        }
        //if the remove node is not the root node, we need to find out if it's in left/right subtree
        if (key < root.key) {//target is in the left subtree
            root.left = deleteTree(root.left, key);
        } else {//target is in the right subtree
            root.right = deleteTree(root.right, key);
        }
        return root;
    }

    public TreeNode FindSuccessor(TreeNode root) {
        //successor has to disconnect with its parent node
        TreeNode pre = null;
        while (root.left != null) {
            root = root.left;
            pre = root;
        }
        pre.left = null;
        return root;
    }

    public static void main(String[] args) {

    }
}
