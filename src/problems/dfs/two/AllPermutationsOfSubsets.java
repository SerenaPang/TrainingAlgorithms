package problems.dfs.two;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }
    private void helper(char[] array, int index, List<String> result){
        //every state in the recursion tree is a valid result
        result.add(new String(array, 0, index));
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
