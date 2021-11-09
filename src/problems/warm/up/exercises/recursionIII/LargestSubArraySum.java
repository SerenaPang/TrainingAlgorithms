package problems.warm.up.exercises.recursionIII;

public class LargestSubArraySum {
    /** max: 2 5
     int[] arr = new int[]{2, -1, 4, -2, 1};
                           2  1   5
     * while adding the rest of the numbers, we keep track of the maximum array sum
     *
     * TC:O(n)
     * SC: O(n)
     * */
    public int largetSum(int[] array){
        int[] memo = new int[array.length];
        memo[0] = array[0];
        int globalMax = memo[0];
        for (int i = 1; i < array.length; i++) {
           memo[i] = memo[i -1] + array[i];
           globalMax = Math.max(memo[i], globalMax);
        }
        print(array);
        print(memo);
        return globalMax;
    }

    /**
     * optimize the space complexity by not using the memo array
     * we only need to record the latest max sum of the array
     *
     * TC: O(n)
     * SC: O(1)
     * */
    public int findLargestSum(int[] array) {
        int globalMax = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            //if the previous + cur > cur itself
            System.out.print("cur: " + cur + " ");
            cur = Math.max(cur + array[i], array[i]);
            //update max
            globalMax = Math.max(globalMax, cur);
        }
        return globalMax;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //max: 2 5
        int[] arr = new int[]{2, -1, 4, -2, 1};
        //                    2  1   5
        int[] array = new int[]{-2, -1, -3};

        LargestSubArraySum largest = new LargestSubArraySum();
        int result = largest.largetSum(arr);
        System.out.println("the largest subarray sum is: " + result);

        int max = largest.findLargestSum(arr);
        System.out.println("the largest subarray sum is: " + max);
    }
}
