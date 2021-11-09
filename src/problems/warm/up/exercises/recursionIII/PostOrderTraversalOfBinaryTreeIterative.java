package problems.warm.up.exercises.recursionIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderTraversalOfBinaryTreeIterative {
    /**
     * TC: O(n)
     * SC: O(height)
     * */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.offerFirst(root);
        //to record the previous node on the way of DFS so that
        //we can determine the direction
        TreeNode previousNode = null;
        while (!stack.isEmpty()) {
            TreeNode currentRoot = stack.peekFirst();
            //check if we can going down from the root to either right or left,
            //previous is the parent node, cur is the sub node of pre
            if (previousNode == null || currentRoot == previousNode.left || currentRoot == previousNode.right) {
                //check the left node exist first since we want to visit left in post order traversal
                if (currentRoot.left != null) {
                    stack.offerFirst(currentRoot.left);
                } else if (currentRoot.right != null) {
                    stack.offerFirst(currentRoot.right);
                } else {//when left and right are null, cur is a leaf node, because we are at leaf node, we can poll the node from the stack
                    //and add it to list
                    stack.pollFirst();
                    result.add(currentRoot.key);
                }
            }
            //cur is the parent node and the pre is the sub nodes, so here we are coming from the sub nodes to the up
            //but we have to pay attention that if it's coming from the left or from the right side
            else if (previousNode == currentRoot.right || previousNode == currentRoot.left && currentRoot.right == null) {
                //if we are not going down anymore, which is the case that we are coming from the right side or
                // we come up from the left but not going to right(right is null)
                stack.pollFirst();
                result.add(currentRoot.key);
            }
            //if pre is not the parent node, cur is parent node, and pre is the sub node.
            //we are coming from the left side and we are going down to the right side
            else {
                stack.pollFirst(currentRoot.right);
            }
            //remember that every iteration is done, record the current node as previous node
            previousNode = currentRoot;
        }
        return result;
    }

    public void print(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);

        five.left = three;
        five.right = eight;
        three.left = one;
        three.right = four;
        eight.right = eleven;

        PostOrderTraversalOfBinaryTreeIterative post = new PostOrderTraversalOfBinaryTreeIterative();
        List<Integer> result = post.postOrder(five);
        post.print(result);
    }
}
