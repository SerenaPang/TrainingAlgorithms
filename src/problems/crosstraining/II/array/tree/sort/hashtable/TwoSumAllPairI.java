package problems.crosstraining.II.array.tree.sort.hashtable;

import java.util.*;

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
        for (int i = 0; i < array.length; i++) {
            //get all the indexes sum to target with current number

            List<Integer> indexes = map.get(target - array[i]);
            if (indexes != null) {//if there are indexes sum to target with curretn number
                //add all of them as pairs
                for (int j = 0; j < indexes.size(); j++) {
                    result.add(Arrays.asList(indexes.get(j), i));
                }
            }
            //add current index i to all the possible indices for value of array[i]
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
            printList( map.get(array[i]));
        }
        return result;
    }

    public void printList(List<Integer> list) {
        System.out.println("Printing List: ");
        for (int i = 0 ; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("Done");
    }

    public void print(List<List<Integer>> result) {
        for (List aList : result) {
            System.out.println(aList);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,2,4};
        int target = 5;

        TwoSumAllPairI t = new TwoSumAllPairI();
       // List<List<Integer>> result = t.allPairs(num, target);
        List<List<Integer>> result = t.allPairsII(num, target);
        t.print(result);
    }
}
