package problems.crosstraining.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        //all pairs that sums to target
        List<List<Integer>> result = new ArrayList<>();

        //map that stores all elements in the array, index as key, elements as values
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }

        for (int j = 0; j < array.length; j++) {
            int cur =  array[j];
            int diff = Math.abs(cur - target);
            if (map.containsValue(diff)) {
                List<Integer> aPair = new ArrayList<>();
                aPair.add(j);
                aPair.add(diff);
                result.add(aPair);
            }
        }
        return result;
    }

    public List<List<Integer>> allPairsII(int[] array, int target) {
        //all pairs sum to target
        List<List<Integer>> result = new ArrayList<>();
        //key: element in array value: all possible indexes
        Map<Integer, List<Integer>> map = new HashMap<>();

    }


    public void print(List<List<Integer>> result) {
        for (List aList : result) {
            System.out.println(aList);
//            for (int i = 0; i < result.size(); i++) {
//                System.out.print(result.get(i) + " ");
//            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,2,4};
        int target = 5;

        TwoSumAllPairI t = new TwoSumAllPairI();
        List<List<Integer>> result = t.allPairs(num, target);
        t.print(result);
    }
}
