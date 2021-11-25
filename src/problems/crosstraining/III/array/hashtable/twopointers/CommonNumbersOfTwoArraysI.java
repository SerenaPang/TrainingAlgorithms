package problems.crosstraining.III.array.hashtable.twopointers;

import java.util.*;

public class CommonNumbersOfTwoArraysI {
    /**
     * TC: O(n^2) + O(nlogn)
     * SC: O(n)
     * find common elements in these 2 unsorted arrays
     * and return result in ascending order
     *
     * put all element of the shorter array in hashset
     * iterate through the other array to find common element
     * */
    public List<Integer> common(int[] a, int[] b){
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }
        for (int j = 0; j < a.length; j++) {
            if (set.contains(a[j])) {
                result.add(a[j]);
            }
        }
        //set does not sort the element by itself so we will sort it
        Collections.sort(result);
        return result;
    }

    public void printHashSet(Set<Integer> h) {
        Iterator<Integer> iterator = h.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
       System.out.println();
    }

    public void print(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{3,1,4};
        CommonNumbersOfTwoArraysI c = new CommonNumbersOfTwoArraysI();
        List<Integer> result = c.common(A, B);
        c.printArr(A);
        c.printArr(B);
        System.out.println("The common element of these 2 arrays: ");
        c.print(result);
    }
}
