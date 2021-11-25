package problems.crosstraining.II.array.tree.sort.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * TC: O(n^2)
     * SC: O(1) not counting the storage for result
     * */
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            /**
             * Find i < j < k such that array[i] + array[j] + array[k] == target
             * To make sure there is no duplicate tuple, we ignore all the duplicate possible i
             * if we have 2,2,2 only the firt 2 will be selected as i
             * */
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    //ignore all possible duplicate j as well
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (tmp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
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
        ThreeSum t = new ThreeSum();
        int[] array = new int[]{1,2,2,3,2,4};
        int target = 8;
        List<List<Integer>> result = t.allTriples(array, target);
    }
}
