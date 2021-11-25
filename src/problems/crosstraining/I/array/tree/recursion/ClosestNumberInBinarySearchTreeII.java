package problems.crosstraining.I.array.tree.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Solution 1: Step 1: in order traversal O(n) step 2: binary search + expand to both sides O(logn) + k
 *
 * Solution 2: Sliding window of size k
 * */
public class ClosestNumberInBinarySearchTreeII {
    /**
     * This function finds the closest k number of nodes to the target
     * using binary search
     *
     * when we have the number that's closest to the target, we can expand from both direction
     * to get k number of nodes that are close to the target
     * */
    public int[] closestKValues(TreeNode root, double target, int k) {
        int[] result = new int[k];
        int[] array = serializedTree(root);
        int largestSmallerIndex = largestSmallerThanOrEqualsToTarget(array, (int)target);

        //from the center expand to the left and right side until we have k closest elements to the target
        int left = largestSmallerIndex;
        int right = largestSmallerIndex + 1;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && target - array[left] <= array[right] - target || right >= array.length) {
                result[i] = array[left];
                left--;//remember to move the index each time we add an element to the result
            } else {
                result[i] = array[right];
                right++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * This function finds the largest number smaller than or equals to the target
     * return the index
     * */
    public int largestSmallerThanOrEqualsToTarget(int[] array, int target) {
        int left = 0;
        int right = array.length -1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + array[left] + " right: " + array[right]);

       if (array[left] <= target) {
            return left;
        }
       if (array[right] <= target) {
            return right;
        }
       return -1;
    }

    /**
     * This function converts the list of nodes to an array of integer so it's easier to apply binary search
     * on the serialized tree
     * */
    public int[] serializedTree(TreeNode root) {
        List<Integer> treeAsList = new ArrayList<>();
        InOrderTraversal(root, treeAsList);

        int[] result = new int[treeAsList.size()];
        for (int i = 0; i < treeAsList.size(); i++) {
            result[i] = treeAsList.get(i);
        }
        return result;
    }

    /**
     * This function use in order traversal to get the tree node values in a list in ascending order
     * */
    public void InOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, result);
        result.add(root.key);
        InOrderTraversal(root.right, result);
    }

    /**
     * This function prints an array
     * */
    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(14);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        ClosestNumberInBinarySearchTreeII cb = new ClosestNumberInBinarySearchTreeII();
        int[] array = cb.serializedTree(a);
        cb.print(array);
        //int target = 6;
        //int target = 4;
        int target = 10;
        int largestSmaller = cb.largestSmallerThanOrEqualsToTarget(array, target);
        System.out.println("The largest number smaller than the "+ target + " is: " + array[largestSmaller] + " at index " + largestSmaller);

        int k = 3;
        System.out.println(k + " numbers that are closest to " + target + " in this tree are ");
        int[] closestNumbers = cb.closestKValues(a, target, k);
        cb.print(closestNumbers);
    }

}
