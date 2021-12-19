package problems.recursion.sorting;
/**
 *  TC: O()
 *  SC: O()
 * */
public class SelectionSort {
    public int[] solve(int[] array) {
        int[] result = new int[array.length];

        return result;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = new int[]{1};
        //int[] array = new int[]{1,2,3};
        //int[] array = new int[]{3,2,1};
        //int[] array = new int[]{4,2,-3,6,1};

        SelectionSort s = new SelectionSort();
        int[] reslut = s.solve(array);

        s.print(array);
        s.print(reslut);
    }
}
