package problems.recursion.sorting;

public class RainbowSort {
    /**
     * TC: O(n)
     * SC: O(n)
     * create counters to count the number of -1, 0, and 1s. and then populate them in the result array
     * */
    public int[] rainbowSortI(int[] array) {
       int[] result = new int[array.length];
       int neg = 0;
       int zero = 0;
       int one = 0;
       for (int i = 0 ; i < array.length; i++) {
           if (array[i] < 0) {
               neg++;
           } else if (array[i] == 0) {
               zero++;
           } else {
               one++;
           }
       }
       System.out.println("There are " + neg + " negative number," + zero + " zeros, and " + one + " ones.");

        //populate result array
        for (int j = 0; j < neg; j++) {
           result[j] = -1;
        }

        for (int a = neg; a < (neg + zero); a++) {
            result[a] = 0;
        }

        for (int b = (neg + zero); b < result.length; b++) {
            result[b] = 1;
        }
       return result;
    }
    /**
     * divide the array into 4 sections
     * -1: 0 - i - 1
     * 0: i - j - 1
     * 1: j - k
     * k - end

     * i = 0
     * j = 0
     * k = array.length
     * [j,k]:unexplored area
     *
     * -1 -1 -1 -1 -1 0 0 0 0 1 1 1 1 1 -1
     *                i       j       k
     *                neg     zero    one
     * -1 0 1 1 1 -1 0 0 1 0 -1 1 -1 -1
     *  i
     *  j
     *    k
     *
     * -1 0
     *
     * a b c c c a b b c b a c a a
     *
     * we swap the zero and one, and then we swap neg and zero
     * TC: O(n)
     * TC: O(1)
     * */
    public int[] rainbowSortII(int[] array) {
        int neg = 0;
        int zero = 0;
        int one = array.length - 1;
        while (zero < one) {
            if (array[zero] == -1) {
                swap(array, neg, zero);
                neg++;
                zero++;
            } else if (array[zero] == 0) {
                zero++;
            } else {
                swap(array, zero, one);
                one--;
            }
        }

        return array;
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] array = new int[]{1,0,1,-1,0};
        int[] array = new int[]{-1, 0, 1, 1, 1, -1, 0, 0, 1, 0, -1, 1, -1, -1};
        RainbowSort r = new RainbowSort();
        r.print(array);
        //int[] result = r.rainbowSortI(array);
        int[] result = r.rainbowSortII(array);
        r.print(result);
    }
}
