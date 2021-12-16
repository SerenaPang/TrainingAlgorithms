package problems.binary.search;

public class ClosestInSortedArray {
    /**
     *  if target is the same as the element, return index
     *  if there are two elements that are close to target, return
     * TC: O(logn)
     * SC: O(1)
     * */
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        /**
         * target: 3 should return index 1
         *  0 1 2
         *  1 4 6
         *  l   r
         *    m
         *  m: 0 + (2-0) / 2 = 1
         *
         *  0 1 2
         *  1 4 6
         *  l r
         *  at this moment, r - 1 equals to l, so we have to stop to compare these two numbers
         *  and find out which one is closer to target.
         *  if we don't stop here, l and r will overlap in the next iteration and we won't be able to compare them
         * */
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (target - array[left] <= Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int target = 2;
        ClosestInSortedArray c = new ClosestInSortedArray();
        int result = c.closest(array, target);
        System.out.println("The closest number to target " + target + " in the array is " + array[result] +
                " at index " + result);

    }
}
