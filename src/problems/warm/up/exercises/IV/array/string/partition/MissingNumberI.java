package problems.warm.up.exercises.IV.array.string.partition;

import java.util.HashMap;

public class MissingNumberI {
    /**
     *  array size: is not n, but n - 1
     *  which means n should be length + 1
     *  number range in array: 1 - n
     *  put all number in hash map
     *  loop through 1 - n, check the map for missing number
     * */
    public int missing(int[] array) {
        //key: index value: element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }
        //check who is missing; number range from 1 to n
        int n = array.length + 1;
        for (int j = 1; j <= n; j++) {
            if (!map.containsValue(j)) {
              return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] A = new int[]{2,1,4};
        //int[] A = new int[]{2,1,3};
        int[] A = new int[]{};
        MissingNumberI m = new MissingNumberI();
        int result = m.missing(A);
        System.out.println("The missing number is " + result);
    }
}
