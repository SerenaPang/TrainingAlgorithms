package problems.warm.up.exercises.I.array.btree;

public class Move0sToTheEndI {

    public int[] moveZero(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[end] = array[i];
                end++;
            }
        }
        for (int j = end; j < array.length; j++) {
            array[j] = 0;
        }
        return array;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Move0sToTheEndI mv = new Move0sToTheEndI();
        int[] array = new int[]{1,0,3,0,1};
        print(array);
        mv.moveZero(array);
        print(array);
    }
}
