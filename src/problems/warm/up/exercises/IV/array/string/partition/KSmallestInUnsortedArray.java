package problems.warm.up.exercises.IV.array.string.partition;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    /**
     * TC: O(k + (n - k)logk)
     * SC: O(k)
     * use a max heap to filter all the bigger element
     * */
    public int[] kSmallest (int[] array, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        //take k smallest elements in the array
        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < 3) {
                maxHeap.offer(array[i]);
            } else {
                int top = maxHeap.peek();
                if (array[i] < top) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        //populate result array
        for (int j = maxHeap.size() - 1; j >= 0 ; j--) {
           result[j] = maxHeap.poll();
        }
        return result;
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,4,1,2,5};
        int k = 3;
        KSmallestInUnsortedArray kSmallest = new KSmallestInUnsortedArray();
        kSmallest.print(A);
        int[] result = kSmallest.kSmallest(A, k);
        System.out.println("The samllest " + k + " numbers are ");
        kSmallest.print(result);
    }
}
