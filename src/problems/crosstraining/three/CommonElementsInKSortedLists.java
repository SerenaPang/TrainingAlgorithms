package problems.crosstraining.three;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInKSortedLists {

    public List<Integer> commonElementsInKSortedLists(List<List<Integer>> input) {
        List<Integer> result = new ArrayList<>();

        return result;
    }
    public void print(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
                //new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);

        b.add(2);
        b.add(2);
        b.add(3);
        b.add(5);

        c.add(2);
        c.add(2);
        c.add(4);

        CommonElementsInKSortedLists common = new CommonElementsInKSortedLists();
        List<Integer> result = common.commonElementsInKSortedLists(input);
        System.out.println("The common elements in these 3 arrays are: ");
        common.print(result);
    }
}
