package problems.crosstraining.one;

import java.util.Arrays;

public class ArrayDeduplicationII {
    private int[] deDup(int[] num) {
        if (num == null || num.length <= 2) {
            return num;
        }
        int end = 1;
        for (int i = 2; i < num.length; i++) {
            if (num[i] != num[end - 1]) {
                end++;
                num[end] = num[i];
            }
        }
        return Arrays.copyOf(num, end + 1);
    }
    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,2,2,3,3,3};
        ArrayDeduplicationII rm = new ArrayDeduplicationII();
        int[] result = rm.deDup(num);
        System.out.println("Result: " + result);
    }
}
