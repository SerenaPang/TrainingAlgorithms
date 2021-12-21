package problems.recursion.sorting;
/**
 * quick sort algorithm:
 * randomly pick pivot in the array, so that we can partition the array base on the pivot value
 * recursively pick a pivot and partition the array
 * swap the pivot to the end of the array, partition the array
 * after partition is done, swap the pivot back to the position
 *
 * */
public class QuickSort {
    /**
     * pick a pivot
     *  2 4 1 5 3
     *    p
     * move pivot to the end
     *  2 3 1 5     4
     *              p
     * partition the array
     * 2 3 1  5  4
     * put pivot back to the array in the appropriate position
     *      4
     * 2 3 1 4 5
     * return the position of the pivot since it's already in the right place where whatever is smaller on the left side, bigger on the right side
     * and partition the left side and then the right side and recursively do these steps until all the elements were partitioned and in the right places
     *
     * */
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        return quickSort(array, left, right);
    }

    /**
     *  function that recursively partition base on pivot
     *  take the pivot and partition
     *  2 4 1 5 3
     *      p
     *
     * move the pivot to the end of the array
     * 2 4 5 3  1
     * partition this array base on the pivot we picked
     *
     *  2 4 5 3
     *  l
     *  r
     *
     *  2 4 5 3  1
     *  l
     *  r
     *  move pivot back to left
     *
     *  1 4 5 3 2
     *  l
     *
     *  find a pivot for 0 - pivot - 1
     *  find a pivot for pivot + 1 - array length
     *
     * pass left and pivot - 1 as left array
     * pass pivot + 1 and right as right array
     *
     * and pivot for partition
     *
     *  return the array that's been partitioned
     * left represents the leftbound, right represents the right bound
     * array is the original array
     * but left and right changes each time we call partition
     *
     * */
    public int[] quickSort(int[] array, int left, int right) {
        if (left <= right) {
            return array;
        }
        int pivotIndex = partition(array, left, right);
        //since we move the pivot to the end, when we do partition, we shouldn't include pivot itself
        int rightBound = right - 1;
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, rightBound);
        return array;
    }

    /**
     * function that recursively partition the array
     *  2 3 1 4 5
     *      p
     *
     * receive the array and
     * 2 3 4 5  1
     *
     * return the pivot index when finished the partition as the boundary for the next partition
     * */
    public int partition(int[] array, int left, int right) {
        //first generate a pivot number
        int pivotIndex = pivotGenerator(left, right);
        int pivot = array[pivotIndex];
        //move the pivot to the end
        swap(array ,pivotIndex, right);

       while (left <= right) {
           if (array[left] < pivot) {
                left++;
           } else if (array[right] > pivot) {
               right--;
           } else {
               swap(array, left, right);
               left++;
               right--;
           }
       }
       //move the pivot back to where is should be
        swap(array, left, array.length - 1);
       //return left which is the pivot , since pivot to the left and to the right are sorted, it will not be included in the next partition
       return left;
    }

    /**
     * function that randomly picks a pivot
     * */
    public int pivotGenerator(int left, int right) {
        return left + (int)(Math.random() * (right - left) + 1);
    }

    /**
     *  function that swap the elements' int the array
     * */
    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       QuickSort q = new QuickSort();
        //int[] array = new int[]{1};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{3,2,1};
        //int[] array = new int[]{4,2,-3,6,1};
        int[] array = new int[]{2,4,1,5,3};
        q.print(array);

        int[] reslut = q.quickSort(array);
        q.print(reslut);
    }
}
