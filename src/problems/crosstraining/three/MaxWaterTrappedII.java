package problems.crosstraining.three;

import java.util.PriorityQueue;

public class MaxWaterTrappedII {

    /**
     * Use Best First Search
     * min heap maintains all the border cells of the "closed area", which are the higher value numbers
     * we always fins the number with lowest value to see if any of its neighbors can trap any water
     * */
    public int maxTrapped(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        //if there are only 4 and less walls, we can not trap any water
        if (rowLen < 3 || colLen < 3) {
            return 0;
        }
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[rowLen][colLen];
        //put all the border cells of the matrix at the beginning
        int result = 0;
        while (!minHeap.isEmpty()) {
            Element cur = minHeap.poll();


        }

        return result;
    }

    /**
     * put all the border cells into the min heap at the very beginning
     * these are the start oints of the whole BFS process
     * */
    public void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Element> minHeap, int rowLen, int colLen) {
        //process the upper row and the bottom row
        for (int col = 0; col < colLen; col++) {
            //put the whole upper row into min heap
            minHeap.offer(new Element(0, col, matrix[0][col]));
            //put the whole bottom row in min heap
            minHeap.offer(new Element(rowLen - 1, col, matrix[rowLen - 1][col]));
            //mark all the visted element
            visited[0][col] = true;
            visited[rowLen - 1][col] = true;
        }
        //process the leftmost column and the rightmost column
        //since we already put the first element when putting upper row, we start with the second row's first element
        //since we already put the first element when putting bottom row, we end the loop in the last second element
        for (int row = 1; row < rowLen - 1; row++) {
            //put left column to minheap
            minHeap.offer(new Element(row, 0, matrix[row][0]));
            //put right column to min heap
            minHeap.offer(new Element(row, colLen - 1, matrix[row][colLen - 1]));
            visited[row][0] = true;
            visited[row][rowLen - 1] = true;
        }
    }

    /**
     * Element's row index, column index and the value(which is the height of the cell) in the
     * original matrix
     * */
    public static class Element implements Comparable<Element> {
        int r;
        int c;
        int height;

        Element(int row, int col, int height) {
            this.r = row;
            this.c = col;
            this.height = height;
        }

        @Override
        public int compareTo(Element another) {
            if (this.height == another.height) {
                return 0;
            }
            return this.height < another.height ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 2, 3, 4, 2 },
                { 3, 1, 2, 3 },
                { 4, 3, 5, 4 }
        };

        MaxWaterTrappedII m = new MaxWaterTrappedII();
        int result = m.maxTrapped(matrix);
        System.out.println("The maximum water trapped in the array is: " + result);
    }

}
