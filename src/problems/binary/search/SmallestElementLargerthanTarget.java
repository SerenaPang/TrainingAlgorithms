package problems.binary.search;
/**
 *  find the number that's larger than target, but it's the closest to the target
 *  return the index of this number
 *  TC: O(logn)
 *  SC: O(1)
 * */
public class SmallestElementLargerthanTarget {
    /**
     * target:
     *  0 1 2
     *  1 2 3
     *
     * */
    public int smallestElementLargerThanTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {//if mid is greater than target, it might be the result, we can not rule out this possible candidate
                right = mid;
            }
        }
        //since we want the smallest index, we should check the left index first
        if (array[left] > target) {
            return left;
        } else if (array[right] > target){
            return right;
        } else { //in case that left and right both smaller or equals to target
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        //int[] array = new int[]{1,2,2,2,3};
        //int target = 1;
        int target = 3;
        SmallestElementLargerthanTarget s = new SmallestElementLargerthanTarget();
        int result = s.smallestElementLargerThanTarget(array,target);
        System.out.println("The closest number larger than target " + target + " is at index " + result);
    }
}
