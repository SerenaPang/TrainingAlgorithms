package problems.dfs.two;
import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, k, sb, 0, result);
        return result;
    }

    public void helper(char[] set, int k, StringBuilder sb, int index, List<String> result) {
        //check if the result is size k, if it is we can terminate immediately so we don't have to
        //to do more dfs with elements more than size of k, and we can adding the result of size k list
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }

        if (index == set.length) {
            return;
        }
        //not pick the char at index
        helper(set, k, sb, index + 1, result);
        //pick
        helper(set, k, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
