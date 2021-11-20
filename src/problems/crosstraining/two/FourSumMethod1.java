package problems.crosstraining.two;

import java.util.Arrays;

public class FourSumMethod1 {
    //Method 1: sort the array first, O(n^3)
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int curTarget = target - array[i] - array[j];
                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == curTarget) {
                        return true;
                    } else if (sum < curTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }
}
