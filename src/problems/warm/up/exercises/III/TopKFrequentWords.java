package problems.warm.up.exercises.III;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    /**
     * create a priority queue of size k (min heap) since we want the most frequent
     * create a map with element as key and number of occurrences of the element as value
     * min heap will compare the occurrences of the elements
     * put k element in the heap and replace it with a bigger element
     * */
    public String[] topKFrequent(String[] combo, int k) {
        String[] result = new String[k];
        Map<String, Integer> occuranceMap = new HashMap<>();
        buildMap(combo, occuranceMap);
       // System.out.println(occuranceMap.entrySet());
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //since the frequencies are represented by Ineger, we can use compareTo
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return result;
    }

    public void buildMap(String[] combo, Map<String, Integer> occuranceMapping) {
        for (int i = 0; i < combo.length; i++) {
            if (!occuranceMapping.containsKey(combo[i])) {
                occuranceMapping.put(combo[i], 1);
            } else {
                int previousCount = occuranceMapping.get(combo[i]);
                occuranceMapping.put(combo[i], previousCount + 1);
            }
        }
    }

    public void print(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] composition = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        int k = 2;
        TopKFrequentWords t = new TopKFrequentWords();
        t.print(composition);
        String[] result = t.topKFrequent(composition, k);
        System.out.println("The most frequent " + k + " words in the composition are: ");
        t.print(result);
    }
}
