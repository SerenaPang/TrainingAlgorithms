package problems.crosstraining.I.array.tree.recursion;

import java.util.Arrays;

public class ArrayDeduplicationIV {
    /**
     * end is going to be the top of the stack
     * -add
     * every time we want to add a new element, we move the stack top by 1 and add it
     * -dedup
     * every time we want to make sure if the later elements are the duplicates, we check if it's
     * the same with the top of the stack
     *
     * -delete
     * every time we want to delete a duplicate, end is also the dup, so we have to do end-- to
     * remove the dup
     *
     * after this process, we still have to check if the current element is the same as the
     * current stack top
     *
     * */
    public int[]deDup(int[] array) {
        int end = -1;
        for (int i = 0; i < array.length; i++) {
            //keep non dup
            //we check if i is the dup as end
            if (end == -1 || array[end] != array[i]) {
                end++;
                array[end] = array[i];
            } else { //delete  dup
                //we are in this condition means that i is already a duplicate with end, so now we have to
                //ignore all dup after i
                //but first we need to check if i will be out of bounds before we increment it, and then iterate throught the rest of the numbers
                while ( i + 1 < array.length && array[end] == array[i + 1]) {
                    i++;
                } //until we stop at the index where they are different
                    end--;
            }
        }
        //Arrays.copyOf returns the length df the new array we want to put, so when we are at index 0
        //we actually want to keep the element at index 0, but if we put end, it's going to be size 0, which is nothing
        //so we have to increment by 1
        return Arrays.copyOf(array,end + 1);
    }

    public void print(int[] num) {
        for (Integer aNum : num) {
            System.out.print(aNum + " ");
        }
    }

    public static void main(String[] args) {
        //int[] num = new int[]{1,2,3,3,3,2,2};
        //int[] num = new int[]{1,1,2,2,2,3};
        int[] num = new int[]{1,1,2,3,3,4,5,5,5};
        ArrayDeduplicationIV rm = new ArrayDeduplicationIV();
        int[] result = rm.deDup(num);
        System.out.println("Result: ");
        rm.print(result);
    }
}
