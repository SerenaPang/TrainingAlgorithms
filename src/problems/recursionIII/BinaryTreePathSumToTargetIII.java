package problems.recursionIII;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumToTargetIII {
/**
 * This function is going to return  true if there is a path to sum to the target number
 * false if there is no such path exist
 * @param root is the tree passed in to check the path
 * @param sum is the target sum that we want to check if there is a path sum to this number
 * */
    public boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //pass down the prefix of the path
        List<TreeNode> path = new ArrayList<TreeNode>();
        return helper(root, path, sum);
    }
    /**
     * helper function for the exist method to find out the sum of the path
     * @param root is the tree passed in
     * @param path is the path sum to the taget number, which contains all the nodes in this path
     * @param targetSum is the target sum
     * */
    private boolean helper(TreeNode root, List<TreeNode> path, int targetSum) {
        //print(path);
        path.add(root);
        //check if we can find a subpath sum to the target ended at the root
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum = sum + path.get(i).key;
            if (targetSum == sum) {
                System.out.println("Yes there is a path sum to " + targetSum);
                return true;
            }
        }
        if (root.left != null && helper(root.left, path, sum)) {
            return true;
        }

        if (root.right != null && helper(root.right, path, sum)) {
            return true;
        }
        //clean up when return to th previous level
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * print all the paths sum to target
     * */
    public void printLists(List<List<TreeNode>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.get(i).size(); j++) {
                System.out.print(paths.get(i).get(j).key + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * print all the nodes sum to target
     * */
    public void print(List<TreeNode> path) {
        System.out.println("Print Nodes: ");
        for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).key + " ");
            }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(14);
        TreeNode f = new TreeNode(3);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;

        BinaryTreePathSumToTargetIII bt = new BinaryTreePathSumToTargetIII();
        int target = 17;
       // bt.findTargetPaths(a, target);
       //bt.print( bt.findTargetPaths(a, target));
       boolean exist = bt.exist(a, target);
        if (exist == true) {
            System.out.println("Yes there is a path sum to " + target);
        }else {
            System.out.println("No there is no such path sum to " + target);
        }
    }
}
