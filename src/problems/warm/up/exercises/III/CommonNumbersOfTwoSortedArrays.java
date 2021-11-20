package problems.warm.up.exercises.III;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    //TC: O(m+n) SC: O(min(m,n)) where m is the size of array a, n is the size of array b
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> result =  new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] == B[bIndex]) {
                result.add(A[aIndex]);
                aIndex++;
                bIndex++;
            } else if (A[aIndex] < B[bIndex]){
                aIndex++;
            } else if (A[aIndex] > B[bIndex]) {
                bIndex++;
            }
        }
        return result;
    }

    public void print(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,1,2,2,3};
        int[] B = new int[]{1,1,2,5,6};

        CommonNumbersOfTwoSortedArrays c = new CommonNumbersOfTwoSortedArrays();
        c.printArr(A);
        c.printArr(B);
        System.out.println("The common numbers: ");
        List<Integer> result = c.common(A, B);
        c.print(result);
    }
}
