package problems.warm.up.exercises.IV.array.string.partition;

public class ClassicalBinarySearch {
    /**
     * TC: O(logn)
     * SC: O(1)
     *
     * return the index of the target, if not found, return -1
     * determine the right and left boundary
     * */
    public int binarySearch(int[] array, int target) {
        //sanity check
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (array[mid] == target) {
              return mid;
          } else if (array[mid] < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
        }
        return -1;
    }

    public static void main(String[] args) {
        ClassicalBinarySearch c = new ClassicalBinarySearch();
        int[] A = new int[]{1,2,3,4,5};
        int tA = 3;
        int resultA =c.binarySearch(A, tA);
        System.out.println("Target " + tA + " is at index " + resultA);
    }
}
