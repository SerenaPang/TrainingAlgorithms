package problems.warm.up.exercises.I;

public class RemoveAdjacentRepeatedCharacters {
    public String deDup(String input) {
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[end - 1]) {
                array[end] = array[i];
                end++;
            }
        }
        return new String(array,0, end);//end is length of the string we want to keep
    }
    public static void main(String[] args) {
        String s = "aaaabbbc";
        RemoveAdjacentRepeatedCharacters rm = new RemoveAdjacentRepeatedCharacters();
        String result = rm.deDup(s);
        System.out.println("Result: " + result);
    }
}
