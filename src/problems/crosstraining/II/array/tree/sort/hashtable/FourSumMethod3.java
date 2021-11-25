package problems.crosstraining.II.array.tree.sort.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FourSumMethod3 {
    /**
     * use HashMap: O(n^2)
     * */
    public boolean exist(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        /**
         * the order of traversing i,j is not arbitrary, we should guarantee we can always look at the pair
         * with the smallest right index
         * */
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[j] + array[i];
                /**
                 * we need to guarantee there exist another pair with right index
                 * smaller than the current pair's left index
                 * */
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
                    return true;
                }
                //we only need to store the pair with smallest right index
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(j,i));
                }
            }
        }

        return false;
    }

    //each pair is representing a pair of numbers in the array by their index
    static class Pair{
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
