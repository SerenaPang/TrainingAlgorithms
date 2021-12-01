package problems.crosstraining.IV.array.hashtable.linkedlist.math;

import java.util.PriorityQueue;

public class KthSmallestInTwoSortedArrays {
    /**
     * find the kth the smallest number in two arrays
     *
     * create a max heap of size k, process the arrays with whoever is smaller
     * put the number into the max heap, until the size of the heap reach k
     * poll the top elemet, which is the k th smallest for bot arrays
     * */
    public int kth(int[] a, int[] b, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        return 0;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,4,6};
        int[] B = new int[]{2,3};
        KthSmallestInTwoSortedArrays k = new KthSmallestInTwoSortedArrays();
        int kth = 3;
        int result = k.kth(A,B,kth);
        System.out.println("The " + kth + " smallest element in these two arrays is " + result);
    }
}
