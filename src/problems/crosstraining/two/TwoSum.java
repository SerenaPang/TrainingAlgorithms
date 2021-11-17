package problems.crosstraining.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * TC: O(n)
     * SC: O(n)
     * put all elements in the array to the map
     * for every element we subtract it to see if the other half contains in map
     * */
    public boolean existSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }

        for (int j = 0; j < array.length; j++) {
            int firstNumber = array[j];
            int difference = Math.abs(firstNumber - target);
            if (map.containsValue(difference)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Optimize space complexity but increase time complexity by sorting the array first
     * TC: O(nlogn)
     * SC: O(1)
     * */
    public boolean existSumII(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length;
        while (left < right) {
            int sum = array[left] + array[right];
            if (target == sum) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       // int[] num = new int[]{1,2,3,4};
       // int target = 5;
        int[] num = new int[]{2,4,2,1};
        int target = 4;
        TwoSum t = new TwoSum();
        boolean result = t.existSum(num, target);
        if (result == true) {
            System.out.println("exist");
        } else {
            System.out.println("Does not exist");
        }
    }
}
