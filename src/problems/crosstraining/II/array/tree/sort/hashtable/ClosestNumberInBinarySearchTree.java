package problems.crosstraining.II.array.tree.sort.hashtable;

public class ClosestNumberInBinarySearchTree {
    /**
     * find the node containing the closest number to the given target number
     * TC: avg O(logn), worst case: O(n)
     * SC: O(1)
     * */
    public int closest(TreeNode root, int target) {
        int result = root.key;
        while (root != null) {
            System.out.println("root: " + root.key + " result: " + result);
            if (root.key == target) {
                return root.key;
            } else {
                //if the current node is closer than the previous, we can return it, if not, we have to exlore more nodes
                if (Math.abs(root.key - target) < Math.abs(result - target)) {
                    result = root.key;
                }
                if (root.key < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);

        five.left = two;
        five.right = eleven;
        eleven.left = six;
        eleven.right = fourteen;

        ClosestNumberInBinarySearchTree closest = new ClosestNumberInBinarySearchTree();
        int target = 6;
        int result = closest.closest(five, target);
        System.out.println("The closest number to target is " + result);
    }
}
