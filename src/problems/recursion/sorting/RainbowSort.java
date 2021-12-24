package problems.recursion.sorting;

public class RainbowSort {
    /**
     * x: from 0 - i (not including i) are the first class of the element,
     * y: from i (including i) to j - 1 (not including j) are the second class of the elements;
     * z: from j to k(the end of the array) are the third class of the elements
     *
     * 0到 i前面都是1类数字（不包括i）， 从 i（包括i）到j（不包括j）是第二类数字，从j（包括j） 到k（包括k）是第三类数字
     * i 和 k 相向而行
     * 当后面的数字要往放的时候，如果是0-i区间，i和j都要往后走，k往前走
     * 当前面的数字要往后面放的时候，如果是
     * z y z x y x -> x x y y z
     * i
     * j
     *           k
     * swap i and k; i++, j++, k--
     * x y z x y z
     *   i
     *   j
     *         k
     *
     * */
    public int[] rainbowSort(int[] array) {


        return array;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,0,1,-1,0};
        RainbowSort r = new RainbowSort();
        r.print(array);
        int[] result = r.rainbowSort(array);
        r.print(result);
    }
}
