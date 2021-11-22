package problems.warm.up.exercises.III;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    /**
     * TC: O(n + nlogk)
     * - put into hasmap: O(N)
     * - minHeap:
     * - offer: O(log1 + log2 + log3 +... + logk) = O(klogk)
     * - size > k pop time = O(n-k)logk
     * - so, time = O(klogk) + O(n-k)logk = O(nlogk)
     * - pop result from heap time = O(klogk)
     *
     * SC: O(n)
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
        //select the most frequent k words
        for (Map.Entry<String, Integer> entry : occuranceMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        //convert result to a sorted array by frequency
        //>= since when we are in 0, we need to populate the value as well
        for (int j = minHeap.size() - 1; j >= 0; j--) {
            result[j] = minHeap.poll().getKey();
        }

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
