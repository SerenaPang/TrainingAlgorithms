package problems.crosstraining.three;

public class MergeTwoSortedArray {
    /**
     * merge the arrays two by two, and store the result in the result array
     * the problem is every time we merge 2 arrays we have to scan the whole result array again in order to merge
     * so the time has increase a lot
     *
     * */
    public int[] merge(int[]one, int[] two) {
        int[] result = new int[one.length + two.length];
        mergeTwo(result, one, two);
        return result;
    }

    /**
     * function that merges 2 arrays
     * */
    public void mergeTwo(int[] result, int[] one, int[] two) {
        int ai = 0;
        int bi = 0;
        int index = 0;
        while (ai < one.length && bi < two.length) {
            if (one[ai] <= two[bi]) {
                result[index] = one[ai];
                ai++;
            } else if (two[bi] < one[ai]) {
                result[index] = two[bi];
                bi++;
            }
            index++;
        }
        //process the leftover elements
        if (ai < one.length) {
          while (ai < one.length) {
                result[index] = one[ai];
                ai++;
                index++;
            }
        }

        if (bi < two.length) {
            while (bi < two.length) {
                result[index] = two[bi];
                bi++;
                index++;
            }
        }
    }

    public void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedArray m = new MergeTwoSortedArray();
        int[] one = new int[]{3};
        int[] two = new int[]{1,2,3,4,5};
        int[] result = m.merge(one, two);
        m.printArr(result);
    }
}
