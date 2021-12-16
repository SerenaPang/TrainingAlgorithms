package problems.binary.search;
/**
 * TC: O(logmn)
 * SC: O(1)
 * */
public class SearchInSortedMatrixI {
    /***
     *    0 1 2 3 4 5 6 7 8
     *    1 2 3 4 5 7 8 9 10
     *    l                r
     *            m
     *    m: 0 + (8-0)/2 = 4
     *
     *     0 1 2 3 4 5 6 7 8
     *     1 2 3 4 5 7 8 9 10
     *             l       r
     *               m
     *     m: 4 + (8-4)/2 = 5
     *
     * */
    public int[] search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1,-1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        //note that the length should be all elements length;if we put matrix len, it will be only the row len
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rowPosition = mid / cols;
            int colPosition = mid / cols;
            if (matrix[rowPosition][colPosition] == target) {
                return new int[]{rowPosition,colPosition};
            } else if (matrix[rowPosition][colPosition] < target){
               left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        //0 1 2 3 4 5 6 7 8
        //1 2 3 4 5 7 8 9 10
        //how to find the location in the matrix when it's in 1d array
        //r: index / col  c: index % col
        //for example: 7 is at index 5 in the array, col is 3, to find the position of 7 in the matrix:
        // row: 5 / 3 = 1; col: 5 % 3 = 2; position in matrix: {1,2}
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,7},
                {8,9,10}
        };
        int target = 7;
        SearchInSortedMatrixI s = new SearchInSortedMatrixI();
        int[] result = s.search(matrix, target);
        System.out.println("target " + target + " is at {" + result[0] + "," + result[1] + "}");
    }
}
