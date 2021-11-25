package problems.crosstraining.III.array.hashtable.twopointers;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    /**
     * TC: O(n)
     * SC: O(n)
     * create a stack with the index of the array
     * */
    public int largest(int[] array) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        //add a bar of height 0 at last since we want to pop elements in the stack at last
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.pollFirst()];
                //determine the left boundary of the largest rectangle wth height array[i]
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                //determine the right boundary of the largest rectangle with height of the poped element
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        int[] array = new int[]{2,1,3,3,4};
        int result = l.largest(array);
        System.out.println("The largest rectangle area is " + result);
    }
}
