package problems.warm.up.exercises.IV.array.string.partition;

public class StringMatching {
    public static void main(String[] args) {
        String anagram = "ab";
        String input = "abcbac";
        System.out.println("Anagram: " + anagram + "    String: " + input);
        //we can't do this since j is going to be greater than i, and the number of characters are decreses each time
        /**
        for (int i = 0; i < input.length(); i++) {
            System.out.println(i);
            for (int j = i; j < anagram.length(); j++) {
                System.out.println("here");
            }
        }
         */
    }
}
