package problems.recursion.sorting;
/**
 * TC: O(n^2)
 * SC: O(1)
 * insertion sort algorithm:
 * values from the unsorted part are picked and placed at the correct position in the sorted part
 * from 0 to i are the sorted part, from i to end of the array are unsorted
 *
 *
 * */
public class InsertionSort {
    private int[] insertionSort(int[] array) {

        return array;
    }
    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        //int[] array = new int[]{1};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{3,2,1};
        //int[] array = new int[]{4,2,-3,6,1};
        int[] array = new int[]{2,4,1,5,3};
        i.print(array);

        int[] reslut = i.insertionSort(array);
        i.print(reslut);
    }
}
