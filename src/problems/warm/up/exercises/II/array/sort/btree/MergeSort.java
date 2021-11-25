package problems.warm.up.exercises.II.array.sort.btree;

public class MergeSort {
    /**
     * TC: O(nlogn); for n time we split into 2 halves, the array size are even
     * SC: O(n)
     * step 1: divide the array in half until it can 't be divide
     * stwp 2: merge the 2 arrays by comparing their elements
     *
     * post processing: it might happen that 1 array finished but the other array
     * are nnot, so we just need to copy all elements from the leftover to the result array
     * */
    public int[] mergeSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        return split(left, right, array);
    }
    /**
     * split the elements for the array
     * */
    public int[] split(int left, int right, int[] array) {
       if (left == right) {
           return new int[]{left};
       }
       int mid = left + (right - left) / 2;
       //here the function calls itself to divide the array again
       int[] leftArray = split(left, mid, array);
       int[] rightArray = split(mid + 1, right, array);
       return merge(leftArray, rightArray);
    }
    /**
     * merge the array in ascending order, each array starts with 1 element because of split method
     * */
    public int[] merge(int[] one, int[] two) {
        int[] result = new int[one.length + two.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < one.length && resultIndex < two.length) {
            if (one[leftIndex] < two[rightIndex]) {
                result[resultIndex] = one[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = two[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }
        //post processing
        while (leftIndex < one.length) {
            result[resultIndex] = one[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (resultIndex < two.length) {
            result[resultIndex] = two[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1};
        // int[] num = new int[]{1,2,3};
        // int[] num = new int[]{3,2,1};
        // int[] num = new int[]{4,2,-3.6,1};

    }
}
