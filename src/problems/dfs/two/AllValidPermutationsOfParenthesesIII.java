package problems.dfs.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidPermutationsOfParenthesesIII {
    private static final char[] PAREN = new char[]{'(', ')','<','>','{','}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] remain = new int[]{l,l,m,m,n,n};
        int targetLen = l * 2 + m * 2 + n * 2;
        StringBuilder sb = new StringBuilder();
        //stack to put the left parens so that we can check if left matches with right
        Deque<Integer> stack = new LinkedList<Integer>();
        List<String> result = new ArrayList<>();
        helper(sb, stack,remain, targetLen, result);
        return result;
    }

    public void helper(StringBuilder sb, Deque<Integer> stack, int[] remain, int targetLen, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i) ) {
                    sb.append(PAREN[i]);
                    stack.offerFirst(i);
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(PAREN[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i - 1);
                    remain[i]++;
                }
            }
        }

    }
}
