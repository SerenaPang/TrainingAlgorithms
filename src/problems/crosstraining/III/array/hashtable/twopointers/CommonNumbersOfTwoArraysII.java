package problems.crosstraining.III.array.hashtable.twopointers;

import java.util.*;

public class CommonNumbersOfTwoArraysII {
    /**
     * when there are repeated element in one array, and the same element in another array
     * store the same quantity of the element in both array in the result
     *
     * create 2 maps store the elements as key and number of occurrence as value
     * add the same number of common elements to result
     *
     * return the result in sorted order
     * */
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        buildMap(A, aMap);
        buildMap(B, bMap);

        Map<Integer, Integer> smallerMap;
        Map<Integer, Integer> biggerMap;
        if (aMap.size() <= bMap.size()) {
            smallerMap = aMap;
            biggerMap = bMap;
        } else {
            smallerMap = bMap;
            biggerMap = aMap;
        }

      Iterator<Map.Entry<Integer, Integer>> iterator = smallerMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
           int key = entry.getKey();
           int value = entry.getValue();
           if (biggerMap.containsKey(key)) {
               //we only want to take the same quantity of the common elements
               int count = Math.min(value, biggerMap.get(key));
               for (int i = 0; i < count; i++) {
                   result.add(key);
               }
           }
        }
        //remember to sort the list
        Collections.sort(result);
        return result;
    }

    /**
     * build a map of elements and their occurrences
     * */
    public void buildMap(int[] array, Map<Integer, Integer> map) {
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            }
        }
    }

    public void print(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2};
        int[] B = new int[]{3,4,2,2,2};
        CommonNumbersOfTwoArraysII c = new CommonNumbersOfTwoArraysII();
        List<Integer> result = c.common(A, B);
        c.printArr(A);
        c.printArr(B);
        System.out.println("The common element of these 2 arrays: ");
        c.print(result);
    }
}
