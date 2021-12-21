package problems.recursion.sorting;
/**
 * mergesort algorithm:
 * recursively split the array until it can't be split
 * recursively merging the result
 *
 *  2 4 1 5 3
 *  l       r
 *  2 4 1   5 3
 *  l   r   l r
 *
 *  each element is an array
 *  2   4   1   5   3
 *  wo compare the values and rearrange the sequence
 *  when we merge elements, it becomes a bigger array
 *  24  15      3
 *
 *  1 2 4 5     3
 *
 *  1 2 3 4 5
 *
 *  TC: split O(nlogn), merge O(n) for n times comparison
 *  SC: O(n), created a new array to store the result
 *
 * */
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        return split(array, left, right);
    }

/**
 *  2 4 1 5 3
 *  l       r
 *      m
 *  2 4 1   5 3
 *  l   r   l r
 *    m     m
 * */
    public int[] split(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArr = split(array, left, mid);
        int[] rightArr = split(array, mid + 1, right);
        return merge(leftArr, rightArr);
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        int left = 0;
        int right = 0;
        int index = 0;
        int[] result = new int[leftArr.length + rightArr.length];
       while (left < leftArr.length && right < rightArr.length) {
            if (leftArr[left] <= rightArr[right]) {
                result[index] = leftArr[left];
                left++;
            } else {
                result[index] = rightArr[right];
                right++;
            }
            index++;
       }
       while (left < leftArr.length) {
           result[index] = leftArr[left];
           left++;
           index++;
       }
        while (right < rightArr.length) {
            result[index] = rightArr[right];
            right++;
            index++;
        }
        return result;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        //int[] array = new int[]{1};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{3,2,1};
        int[] array = new int[]{4,2,-3,6,1};
        //int[] array = new int[]{2,4,1,5,3};
        m.print(array);

        int[] reslut = m.mergeSort(array);

        m.print(reslut);
    }
}
