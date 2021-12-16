package problems.binary.search;

//search for the target appear in the array, return the index location
public class ClassicalBinarySearch {
    /**
     * TC: O(logn), size decrese by half in each iteration
     * SC: O(1), no extra space used
     *
     * */
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0 ) {
            return -1;
        }
        int left = 0;
        int right = array.length -1;

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
        return -1;//if not found
    }

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,5};
        int[] array = new int[]{1,2,2,2,3,4};
        //int target = 3;
        //int target = 6;
        int target = 2;
        ClassicalBinarySearch c = new ClassicalBinarySearch();
        int result = c.binarySearch(array, target);
        System.out.println("result: " + result);

    }

    /** 0 1 2 3 4
     *  1,2,3,4,5
     *  l       r
     *      m
     * m: 0 + (4-0)/2= 2
     *
     * find 1
     * 0 1 2
     * 1,2,3
     * l   r
     *   m
     * m: 0 + (2 - 0) / 2 = 1
     *
     * 0 1 2
     * 1,2,3
     * l
     * r
     * r = m - 1 = 1 - 1 = 0; now left and right arrive at the same index
     * which means when left and right are at the same place, we should continue checking if mid is the target
     *
     * */
}
