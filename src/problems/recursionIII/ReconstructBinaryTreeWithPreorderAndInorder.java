package problems.recursionIII;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    /**
     * According to the sequence of the inorder and preorder, we can construct a binary tree
     *
     * since we know that in pre order, the root is the first node to visit, and in inorder, the root node
     * is the node in the middle of the left subtree and the right subtree
     * */
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        int[] preIndex = new int[]{0};
        int[] inIndex = new int[]{0};
        return helper(preOrder, inOrder, preIndex, inIndex, Integer.MAX_VALUE);
    }
    /**
     * first we can find the boundary the tree from the middle
     * so we need to find the root every time we iterate
     * */
    public TreeNode helper(int[] preOrder, int[] inOrder, int[] preIndex, int[] inIndex, int target) {
        if (inIndex[0] >= inOrder.length || inOrder[inIndex[0]] == target) {//when we arrive to the root, we finish construction
            return null;
        }
        //we know that first element of pre order is the root
        TreeNode root = new TreeNode(preOrder[preIndex[0]]);
        //advance the pre index by 1
        preIndex[0]++;
        root.left = helper(preOrder,inOrder,preIndex, inIndex, root.key);
        //after finish the left subtree, we can advance the index by 1
        inIndex[0]++;
        root.right = helper(preOrder, inOrder, preIndex, inIndex, target);
        return root;
    }
    /**
     * Method 2: Utilizing the inorder sequence to determine the size of left/right subtrees
     * assume there are no duplicates in th tree
     * */
    public TreeNode reconstractII(int[] in, int[] pre){
        Map<Integer, Integer> inIndex = indexMap(in);
        return helperII(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }

    /**
     * @param pre preorder sequence of the binary tree
     * @param inIndex map that has the key as the inorder sequqnce element, and index as its value
     * @param inLeft inorder starting index
     * @param inRight inorder ending index
     * @param preLeft pre order starting index
     * @param preRight preorder ending index
     *
     * */
    public TreeNode helperII(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        //we know the first element of pre is the root
        TreeNode root = new TreeNode(pre[preLeft]);
        //now find the positiono f the root in inorder sequence, so that we will know the size of the left/right tree
        int inOrderMidRootPosition = inIndex.get(root.key);
        root.left = helperII(pre, inIndex, inLeft, inOrderMidRootPosition - 1, preLeft + 1,preLeft + inOrderMidRootPosition - inLeft);
        root.right = helperII(pre, inIndex, inOrderMidRootPosition + 1, inRight, preRight + inOrderMidRootPosition - inRight + 1, preRight);
        return root;
    }

    /**
     * This function builds a map which takes the elements in the in order sequence and map it with the
     * index for fast access
     * */
    public Map<Integer, Integer> indexMap(int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }


    public static void main(String[] args) {
        int[] preOrder = new int[]{5, 3, 1, 4, 8, 11};
        int[] inOrder = new int[]{1, 3, 4, 5, 8, 11};


    }
}
