package problems.warm.up.exercises.III.array.hashtable;

public class LongestConsecutive1s {
    /**
     * TC: O(n), n is the size of the array
     * SC: O(1)
     * */
    public int longest(int[] array) {
        print(array);
        int globalMax = 0;
        int[] memo = new int[array.length];
        if (array[0] == 0) {
            memo[0] = 0;
        } else {
            memo[0] = 1;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                memo[i] = 0;
            } else {//2 cases: 0 previously or consecutive 1s
                if (memo[i - 1] == 0) {
                    memo[i] = 1;
                } else {
                    memo[i] = memo[i - 1] + 1;
                    globalMax = Math.max(globalMax, memo[i]);
                }
            }
        }

        print(memo);
        return globalMax;
    }

    public void print (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LongestConsecutive1s l = new LongestConsecutive1s();
        int[] arr = new int[]{0,1,0,1,1,1,0};
        System.out.println("The longest consecutive 1 array length is: " + l.longest(arr));
    }
}
