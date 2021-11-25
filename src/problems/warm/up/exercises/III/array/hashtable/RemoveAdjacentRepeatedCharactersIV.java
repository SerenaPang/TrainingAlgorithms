package problems.warm.up.exercises.III.array.hashtable;

public class RemoveAdjacentRepeatedCharactersIV {
    /**
     * TC: O(n) where n is the length of input
     * SC: O(n) where nn is the length of input
     *
     * two pointers scan from left to right
     * using the index position of first pointer as the top of the stack
     * replace the character if it's not duplicate
     * */
    public String deDup(String input) {
      char[] array = input.toCharArray();
      int slow = 0;
      for (int fast = 1; fast < array.length; fast++) {
          if (slow == -1 || array[slow] != array[fast]) {
              slow++;
             array[slow] = array[fast];
          } else {
              while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                  fast++;
              }
              slow--;
          }
      }
      return new String(array, 0, slow + 1);
    }

    public static void main(String[] args) {
        String s = "abbbaaccz";
        String s1 = "aabccdc";
        RemoveAdjacentRepeatedCharactersIV r = new RemoveAdjacentRepeatedCharactersIV();
        System.out.println(s);
        System.out.println(r.deDup(s));
    }
}
