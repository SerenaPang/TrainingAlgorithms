package problems.crosstraining.III.array.hashtable.twopointers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    /**
     *
     * Create a minHeap to put all the Entries(the array element value with its position in the 2D array)
     * Put all element in the heap, and use comparator to implement the internal priority
     * when polling elemebts from the min heap, it will poll all smaller elements first
     * so we are al=ble to populate result
     * */
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        //the result array length should be the length of all arrays added together
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            //the current array
            int[] array = arrayOfArrays[i];
            //update the length
            length = length + array.length;
            //offer the element to heap with row col and val info
            if (array.length != 0) {
                //offering the first element of every row to min heap in ith row
                //since all the arrays are sorted, so the first elements are the smallest in their rows
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        //result array with new length
        int[] result = new int[length];
        int resultIndex = 0;
        //populate result
        while (!minHeap.isEmpty()) {
            Entry currentElement = minHeap.poll();
            System.out.println("polling: " + currentElement.value);
            result[resultIndex] = currentElement.value;
            resultIndex++;
            //check if col index is out of bound
            if (currentElement.col + 1 < arrayOfArrays[currentElement.row].length) {
                //use the same row index, and advance the col index by 1 to read more elements in this row
                currentElement.col++;
                currentElement.value = arrayOfArrays[currentElement.row][currentElement.col];
                System.out.println("offering: " + currentElement.value);
                minHeap.offer(currentElement);
            }
        }
        return result;
    }

    /**
     * Comparator class overide the compare method for comparing the entry set
     * the smaller the higher priority
     * */
    public static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
           if (o1.value == o2.value) {
               return 0;
           }
           return o1.value < o2.value ? -1 : 1;
        }
    }

    /**
     *  Entry class records the row numbwe, column number and corrresponding value
     *  for the array element
     * */
    public static class Entry {
        int row;
        int col;
        int value;

      public Entry (int r, int c, int val) {
            this.row = r;
            this.col = c;
            this.value = val;
        }
    }

    public void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void printTwoDimentionalArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeKSortedArray m = new MergeKSortedArray();
        int[][] a = new int[][]{
                {3},
                {1,2,3,4,5}
        };
        m.printTwoDimentionalArr(a);
        System.out.println("result: ");
        int[] result = m.merge(a);
        m.printArr(result);
    }
}
