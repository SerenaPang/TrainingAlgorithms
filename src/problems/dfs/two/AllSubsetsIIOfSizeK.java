package problems.dfs.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIOfSizeK {
    public List<String> subSetIIofSizeK(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, k, sb, 0, result);
        return result;
    }

    public void helper(char[] set, int k, StringBuilder sb, int index, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (sb.length() == set.length) {
            return;
        }
        helper(set, k, sb.append(set[index]), index + 1, result);
        //before choosing not to pick, we have to skip all the duplicated chars
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index++;
        }
        helper(set, k, sb, index + 1, result);
    }
}
