package problems.recursion.sorting;
/**
 *  selection sort algorithm:
 *  select the smallest element each iteration and swap it with the element in the front
 *
 *  TC: O(n^2)
 *  SC: O(1), we are modifying(swap character positions in the array)
 *
 *   smallest: max
 *   4,2,-3,6,1
 *   i
 *    j
 *
 *   smallest: max
 *   4,2,-3,6,1
 *   i
      j
 * */
public class SelectionSort {
    //i represent the biggest number smaller than the rest of the numbers, before i are the numbers that are already sorted
    //j is used to iterate the unsorted numbers and find the smallest number in the rest of the unsorted array
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        /**
         * small: 0
         *  1 2 3
         *    i
         *     j
         * */
        for (int i = 0; i < array.length; i++) {
            //remember here we should set the smallest number to the position where we are going to swap the next sallest number instead of 0 or max int
            int smallestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(array, i, smallestIndex);
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        //int[] array = new int[]{1};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{3,2,1};
        //int[] array = new int[]{4,2,-3,6,1};
        int[] array = new int[]{2,4,1,5,3};
        s.print(array);

        int[] reslut = s.solve(array);


        s.print(reslut);
    }
}
