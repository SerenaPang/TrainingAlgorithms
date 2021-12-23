package problems.recursion.sorting;
/**
 * TC: O(n^2)
 * SC: O(1)
 * insertion sort algorithm:
 * values from the unsorted part are picked and placed at the correct position in the sorted part
 * from 0 to i are the sorted part, from i to end of the array are unsorted
 *
 *  2 4 1 5 3
 *    i
 *
 *  j smaller than i
 *  2 4 1 5 3
 *  i
 *      j
 *
 *  i scan the array and finds that it's bigger than the previous number
 *  2 4 1 5 3
 *      i
 *
 *  j finds the most appropriate place to put the number
 *   2 4 1 5 3
 *       i
 *   j
 *
 *  j - i-1 move to j + 1 - i
 *
 *  0 1 2 3 4
 *  2 4 1 5 3
 *  j   i
 *
 *  0 1 2 3 4
 *  2 4 1 5 3
 *  j   i
 *
 *  变成
 *  1 2 4
 *
 *  i 后面的数字不用管
 *  0 1 2 3 4
 *  2 4 1 5 3
 *  j
 *      i
 * 2 4 1
 *     i
 *     4
 *
 * 2 4 1
 *   i
 *   2 4
 *
 * 2 4 1
 * i
 * j
 *
 * 1 2 4
 *     i
 * 当i走到j的时候，j应该放入array【i】的值，因为它是最合适的位置， index 0的时候
 *
 *  我们知道要把i放到j所在的位置，必须把从j到i-1的所有数字，剪下来并粘贴到从j+1到i的位置
 *  我们必须从后面的数字开始往后移动1位： array【i】赋值为array【i-1】，
 *
 * j scan the array, check if it's smaller than the previous elements,and then
 * scan through the previous numbers and find the right place to put this number
 * move all the numbers one step ahead
 *
 * */
public class InsertionSort {
    private int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("index: " + i );
            print(array);

            //array[i] is the number that needs to be reallocated
            int value = array[i];
            if (value < array[i - 1]) {
                //System.out.println("array i: " + array[i] + " needs to be reallocate");
                //j represents where we are going to put the number
               int j = i - 1;
               while (j > 0) {
                   //j will stop at the value that's greater than value and previous value is smaller than value
                   if (array[j] > value && array[j - 1] < value) {
                       break;
                   }
                   j--;
               }
                //i是可以被覆盖的，因为i需要被调到前面的j的位置
                //给j赋值array【i】 但首先我们需要copy所有的
                //从i往回走把所有的elements copy 到后面一位，直到i走到j的位置时停下
                //k represents 从i往回走去copy的index
                int k = i;
                while (k != j) {
                    array[k] = array[k - 1];
                    k--;
                }
                array[j] = value;
                }
            }
        System.out.println();
        print(array);
        return array;
    }

    /**
     * array is the original array
     * starting index is where we start copying the array, ending index is where we
     * move j _ i to j + 1 _ i
     * */
    public void move(int[] array, int startingIndex, int endingIndex) {
        for (int i = endingIndex; i > startingIndex; i--) {
            array[endingIndex] = array[endingIndex - 1];
        }
    }
    public void print(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
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

        int[] reslut = i.insertionSort(array);
        //i.print(reslut);
    }
}
