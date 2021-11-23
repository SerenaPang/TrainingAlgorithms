package problems.crosstraining.three;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInKSortedLists {
    /**
     * find common elements in the lists two by two
     * TC: k * O(n), n is the len of each sorted list
     * SC: O(n)
     * */
    public List<Integer> commonElementsInKSortedLists(List<List<Integer>> input) {
        List<Integer> result =  input.get(0);
        for (int i = 1; i < input.size(); i++) {
           result = commonElementsInTwoList(result, input.get(i));
        }
        return result;
    }

    public List<Integer> commonElementsInTwoList(List<Integer> one, List<Integer> two) {
        List<Integer> result = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        while (ai < one.size() && bi < two.size()) {
            if (one.get(ai) == two.get(bi)) {
                result.add(one.get(ai));
                ai++;
                bi++;
            } else if (one.get(ai) < two.get(bi)) {
                ai++;
            } else {
                bi++;
            }
        }
        return result;
    }

    public void print(List<Integer> result) {
        System.out.println("Printing list:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();

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

        input.add(a);
        input.add(b);
        input.add(c);

        CommonElementsInKSortedLists common = new CommonElementsInKSortedLists();
        common.print(a);
        common.print(b);
        common.print(c);
        List<Integer> result = common.commonElementsInKSortedLists(input);
        System.out.println("The common elements in these 3 lists are: ");
        common.print(result);
    }
}
