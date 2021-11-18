package problems.crosstraining.two;

import java.util.HashMap;
import java.util.Map;

public class GetCountArray {
    /**
     * find  out how many number on the right side of the
     * current number are smaller than the current number
     * */
    public int[] countArray(int[] array) {
        int[] result = new int[array.length];
        //key: number value: number of values smaller than the key
        Map<Integer, Integer> map = new HashMap<>();
        int counts = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            //innner loop check all numbers and populate counts
            for (int j = i; j < array.length; j++) {
                if (array[j] < num) {
                  if (!map.containsKey(num)) {
                    counts = 1;
                    map.put(num, counts);
                  } else {
                      int val = map.get(num) + 1;
                      map.put(num, val);
                  }
                } else {
                    map.put(num, counts);
                }
            }
        }
      //  printMap(map);
        for (int k = 0; k < array.length; k++) {
            int key = array[k];
            int count = map.get(key);
         //   System.out.println("index: " + k + " key: " + key + " count: "  + count);
            result[k] = count;
        }
        return result;
    }

    public void printMap(Map<Integer, Integer> map) {
        System.out.println("Printing map: ");
       // System.out.println(map.keySet());
        System.out.println(map.entrySet());
    }
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = new int[]{4,1,3,2};
        GetCountArray g = new GetCountArray();
        g.print(array);
        int[] result = g.countArray(array);
        g.print(result);
    }
}
