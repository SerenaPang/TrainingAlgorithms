package problems.crosstraining.one;

import problems.warm.up.exercises.I.RemoveAdjacentRepeatedCharacters;

public class ArrayDeduplicationI {
    public String deDup(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] array = s.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[end - 1]) {
                array[end] = array[i];
                end++;
            }
        }
        return new String(array, 0, end);
    }

    public static void main(String[] args) {
        String s = "aaaabbbc";
        ArrayDeduplicationI rm = new ArrayDeduplicationI();
        String result = rm.deDup(s);
        System.out.println("Result: " + result);
    }

}
