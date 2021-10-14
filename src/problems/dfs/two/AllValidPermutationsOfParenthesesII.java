package problems.dfs.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidPermutationsOfParenthesesII {
    private static final char[] PAREN = new char[]{'(', ')','<','>','{','}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] remain = new int[]{l,l,m,m,n,n};
        int targetLen = l * 2 + m * 2 + n * 2;
        StringBuilder sb = new StringBuilder();
        //stack to put the left parens so that we can check if left matches with right
        Deque<Character> stack = new LinkedList<Character>();
        List<String> result = new ArrayList<>();
        helper(sb, stack,remain, targetLen, result);
        return result;
    }

    public void helper(StringBuilder sb, Deque<Character> stack, int[] remain, int targetLen, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {//if we need to put at least 1 pair of this parenthese
                    sb.append(PAREN[i]);
                    stack.offerFirst(PAREN[i]);
                    remain[i]--;//since we have put 1 pair, we decrease it by one
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == PAREN[i - 1]) {
                    sb.append(PAREN[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(sb, stack, remain, targetLen, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(PAREN[i - 1]);
                    remain[i]++;
                }
            }
        }

    }
}
