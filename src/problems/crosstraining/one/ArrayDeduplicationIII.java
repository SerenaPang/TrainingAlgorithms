package problems.crosstraining.one;

import java.util.Arrays;
/**
 * false represents there is no duplicate exist in the array
 * true represents the duplicates has appear before
 * whenever we see duplicate, mark true, when we see new char
 * */
public class ArrayDeduplicationIII {
    public int[] deDup(int[] num) {
        int end = 0;
        boolean flag = false;
        for (int i = 1 ; i <num.length; i++) {
            if (num[i] == num[end]) {
                flag = true;
            } else if (flag == true) {
                num[end] = num[i];
                flag = false;
            } else {//only move end when there is new number added
                end++;
                num[end] = num[i];
            }
        }
        return Arrays.copyOf(num, flag ? end : end + 1);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
       // int[] num = new int[]{1,1,1,2,2,3,3,3};
        //int[] num = new int[]{1,2,2,3,3,3};
        int[] num = new int[]{1,2,2,3};
      //  int[] num = new int[]{1,2,3,4};
        print(num);
        ArrayDeduplicationIII rm = new ArrayDeduplicationIII();
        int[] result = rm.deDup(num);
        System.out.println("result:");
        print(result);
    }


}
