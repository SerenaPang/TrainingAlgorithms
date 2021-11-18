package problems.crosstraining.two;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();


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
