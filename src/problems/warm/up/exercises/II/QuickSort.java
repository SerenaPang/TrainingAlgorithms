package problems.warm.up.exercises.II;

import java.util.Random;

public class QuickSort {

    /**
     * step 1: split the array intp 2 halves
     * step 2: for these arrays, pick a pivot and partition the array
     * step 3: partition all element from start to pivot, and pivot + 1 to the end
     *
     * why we don't have to touch pivot again? since in the partition process we already
     * put all elements smaller than pivot to the left and greater than the pivot to the right side
     * */
    public int[] quickSort(int[] array) {
        int left = 0;
        int right = array.length;
        helper(left, right, array);
        return array;
    }

    /**
     * helper method that defines a pivot and
     * use the pivot to partition the array
     * */
    public void helper(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        int pivotPosition = partition(left, right, array);
        partition(left, pivotPosition - 1, array);
        partition(pivotPosition + 1, right, array);
    }

    /**
     * function that partition all elements greater than pivot to the right
     * and all elements smaller than pivot to the left
     *
     * step 1: pick a random pivot and swap it to the end of the array
     * step 2: start partition with the pivot until it reaches to the end of the array
     * step 3: move the pivot back to where end index is since it is the index where the previous
     * elements are smaller than it, and the end index element is the element greater than pivot.
     * note: at this tage, we only partition the small and larger halves, but elements in these halves are not guarantee to be sorted
     * we have to start a new partition for the two halves.
     * Since pivot is already sorted, it does not have to be included, and we pass it as the pivot fot the next partition
     * step 4: pass pivot start a new partition for the rest of the elements
     * */
    public int partition(int left, int right, int[] array) {
        int pivotIndex = pivotGenerator(left, right);
        int pivot = array[pivotIndex];
        swap(pivotIndex, right, array);

        int leftBound = left;
        int rightBound = right - 1; //partition exclude the pivot

        //partition
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] > pivot) {
                rightBound--;
            } else {//when bigger number is in the left or smaller number in the right, swap their positions
                swap(leftBound, rightBound,array);
                leftBound++;
                rightBound--;
            }
        }
        //move the pivot back to appropriate place
        swap(leftBound, right, array);
        //start a new partition without the pivot, so we return the left bound (pivot) index
        return leftBound;
    }

    /**
     * this function randomly pick a pivot as a pivot index within the range of left index and right index
     +1 because math.random generates number form 0 - range - 1, so we have to add it
     left + because left does not start with 0, it starts with whatever we should process the array
     * */
    public int pivotGenerator(int left, int right) {
        return left + (int) (Math.random() * (right - left) + 1);
    }

    /**
     * function that swap the position of the elements in the array
     * */
    public void swap(int left, int right, int[] array) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1};
        // int[] num = new int[]{1,2,3};
        // int[] num = new int[]{3,2,1};
        // int[] num = new int[]{4,2,-3.6,1};
    }
}
