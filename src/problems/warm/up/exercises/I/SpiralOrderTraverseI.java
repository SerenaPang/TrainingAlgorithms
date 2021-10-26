package problems.warm.up.exercises.I;

import java.util.ArrayList;
import java.util.List;

//TC: O(N * N)  SC: O(N)
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        helper(matrix, 0, matrix.length, result);
        return result;
    }

    public void helper(int[][] matrix, int offset, int size, List<Integer> result) {
        System.out.println();
        //when there is 0 element left
        if (size == 0) {
            return;
        }
        //when there is last 1 element left
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }

        //upper row
        for (int i = 0; i < size - 1; i++) {
            System.out.print(matrix[offset][offset + i] + " ");
            result.add(matrix[offset][offset + i]);
        }

        //right col
        for (int i = 0; i < size - 1; i++) {
            System.out.print(matrix[offset + i][offset + size - 1] + " ");
            result.add(matrix[offset + i][offset + size - 1]);
        }
        //bottom row
        for (int i = size - 1; i >= 1; i--) {
            System.out.print(matrix[offset + size - 1][offset + i] + " ");
            result.add(matrix[offset + size - 1][offset + i]);
        }
        //left col
        //terminate when equals to 1 since we don't include the leftmost number
        for (int i = size - 1; i >= 1; i--) {
            System.out.print(matrix[offset + i][offset] + " ");
            result.add(matrix[offset + i][offset]);
        }

        helper(matrix, offset + 1, size - 2, result);
        System.out.println();
    }

    public static void print (List<Integer> integerList) {
        for (Integer aNumber : integerList) {
            System.out.print(aNumber + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,  2,  3,  4,    5,  6,  7, 8},
                {9,  10, 11, 12,  14, 15, 16, 17},
                {18, 19, 20, 21,  22, 23, 24, 25},
                {26, 27, 28, 29,  30, 31, 32, 33},
                {34, 35, 36, 37,  38, 39, 40, 41},
                {42, 43, 44, 45,  46, 47, 48, 49},
                {50, 51, 52, 53,  54, 55 ,56, 57},
                {58, 59, 60, 61,  62, 63, 64, 65}
        };

/**
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
 */
        SpiralOrderTraverseI st = new SpiralOrderTraverseI();
        List<Integer> result = st.spiral(matrix);
        //print(result);
    }
}
