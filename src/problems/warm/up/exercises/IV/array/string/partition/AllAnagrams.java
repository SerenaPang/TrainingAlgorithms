package problems.warm.up.exercises.IV.array.string.partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * return all starting indexes of the anagrams
 * - create a map that the character in the short anagram, and the number of that character
 * - keep track on the number of the total matching characters in string with the size of the map
 * - use sliding window to match all the characters with length of the anagram
 * */
public class AllAnagrams {
    public List<Integer> allAnagrams(String anagram, String input) {
        List<Integer> result = new ArrayList<>();

        //when anagram is longer than input string, there is no way to find any of the substrings
        if (anagram.length() > input.length()) {
            return result;
        }
        //Map records how many characters are needed in the anagram
        Map<Character, Integer> map = buildMap(anagram);
        printMap(map);
        int match = 0;
        System.out.println("Match(before): " + match);

        for (int i = 0; i < input.length(); i++) {
            char curCharacter = input.charAt(i);

            Integer countInMap = map.get(curCharacter);
            if (countInMap != null) {
                map.put(curCharacter, countInMap - 1);
                if (countInMap == 1) {
                    match++;
                }
            }
            //handle the leftmost character at the previous sliding window
            if (i >= anagram.length()) {
                curCharacter = input.charAt(i - anagram.length());
                int index = i - anagram.length();
                countInMap = map.get(curCharacter);
               // System.out.println("cur: " + curCharacter + " at index " + index);
                if (countInMap != null) {
                    map.put(curCharacter, countInMap + 1);
                    if (countInMap == 0) {
                        match--;
                    }
                }
            }

            if (match == map.size()) {
                result.add(i - anagram.length() + 1);
            }
        }
        printMap(map);
        return result;
    }
    /**
     * This function builds a map to record each of the distinct characters in the anagram, and the number of characters in this anagram
     * so that when we get any matching number in the pattern, we decrement by 1, only when the count become 0, we have the pattern totally matched
     * */
    public Map<Character, Integer> buildMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!map.containsKey(curChar)) {
                map.put(curChar, 1);
            } else {
                int previousCount = map.get(curChar);
                map.put(curChar, previousCount + 1);
            }
        }
        return map;
    }


    public void printList(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public void printMap(Map<Character, Integer> map) {
        System.out.println(map.entrySet());
    }

    public static void main(String[] args) {
        String anagram = "ab";
        String input = "abcbac";
        System.out.println("Anagram: " + anagram + "    String: " + input);
        AllAnagrams a = new AllAnagrams();
        List<Integer> result = a.allAnagrams(anagram, input);
        System.out.println("The pattern appears in indexes: ");
        a.printList(result);
    }
}
