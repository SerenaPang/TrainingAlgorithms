package problems.crosstraining.three;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArray {
    /**
     * since the arrays are sorted, we will move the 3 pointers in the array to find the common elements
     **/
    public List<Integer> common(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (ai < a.length && bi < b.length && ci < c.length) {
            if (a[ai] == b[bi] && b[bi] == c[ci]) {
                result.add(a[ai]);
                ai++;
                bi++;
                ci++;
            } else if (a[ai] < b[bi] || a[ai] < c[ci]) {
                    ai++;
            } else if (b[bi] < a[ai] || b[bi] < c[ci]) {
                bi++;
            } else if (c[ci] < a[ai] || c[ci] < b[bi]) {
                ci++;
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
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,3};
        int[] b = new int[]{2,2,3,5};
        int[] c = new int[]{2,2,4};
        CommonElementsInThreeSortedArray common = new CommonElementsInThreeSortedArray();
        common.printArr(a);
        common.printArr(b);
        common.printArr(c);
        List<Integer> result = common.common(a,b,c);
        System.out.println("The common elements in these 3 arrays are: ");
        common.print(result);
    }
}
