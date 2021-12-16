package problems.binary.search;

public class KClosestInSortedArray {

    /**
     * target: 3
     *  0 1 2 3
     *  1 4 6 8
     *    l r
     *
     * find the closest number to the target, starting from this number
     * expand to the left side and right side of this number, to find the other closer numbers to the target
     *
     * TC: O(logn + k)
     * SC: O(k)
     * */
    public int[] kClosest(int[] array, int target, int k) {
        int[] result = new int[k];
        int l = 0;
        int r = array.length - 1;
        int closest = findClosest(array, l, r, target);
        System.out.println("closest index to target " + target + ": " + closest);
        //left is the pointer walks to the left side to select the close values
        int left = closest;
        //right is the pointer
        int right = left + 1;
        //index for populating the results
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && target - array[left] <= Math.abs(array[right] - target) || right >= array.length ) {
                result[index] = array[left];
                left--;
            } else {
                result[index] = array[right];
                right++;
            }
            index++;
        }
        return result;
    }
    /**
     * find the number that's closest to the target
     * */
    public int findClosest(int[] array, int left, int right, int target) {
            while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
            }
            if (target - array[left] < Math.abs(array[right] - target)) {
                return left;
            }else {
                return right;
            }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,4,6,8};
        int target = 3;
        int k = 3;
        KClosestInSortedArray kClose = new KClosestInSortedArray();
        int[] result = kClose.kClosest(array,target,k);
        System.out.println(k + " closest number to target " + target + " are: ");
        for (int i = 0; i < k; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
