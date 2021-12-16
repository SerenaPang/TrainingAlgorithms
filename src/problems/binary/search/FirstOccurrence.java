package problems.binary.search;

public class FirstOccurrence {
    /**
     * find the first occurrence index of the target
     * TC: O(logn)
     * SC: O(1)
     *
     *  0 1 2
     *  1 2 3
     *  l   r
     *    m
     *  m: 1
     *
     *  0 1 2
     *  1 2 3
     *  l r
     *
     * */
    public int firstOccur(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        }

        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int target = 2;
        FirstOccurrence f = new FirstOccurrence();
        int result = f.firstOccur(array, target);
        System.out.println( target + " first occurs at index " + result);
    }
}
