package problems.binary.search;

public class LastOccurrence {
    /**
     * find the index of the last occurrence of the target
     * TC: O(logn)
     * SC: O(1)
     * */
    public int lastOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (array[right] == target) {
            return right;
        }

        if (array[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int target = 2;
        LastOccurrence l = new LastOccurrence();
        int result = l.lastOccur(array, target);
        System.out.println(target + " last occurs at index " + result);
    }
}
