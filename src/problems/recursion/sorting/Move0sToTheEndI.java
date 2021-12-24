package problems.recursion.sorting;
/**
 * TC: O(n)
 * SC: 0(1)
 * */
public class Move0sToTheEndI {
    /**
     *  1 0 3 0 1
     *  i
     *  j
     * before i (including i) represents the elements that are not zero,
     *
     * */
    public int[] moveZero(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != 0) {
                array[i] = array[j];
                i++;
            }
        }
        //since we copy all the non zero elements, we have to put all the zero at the end of the array
        for (int k = i; k < array.length; k++) {
            array[k] = 0;
        }
        return array;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,0,3,0,1};
        Move0sToTheEndI m = new Move0sToTheEndI();
        m.print(array);
        int[] result = m.moveZero(array);
        m.print(array);
    }
}
