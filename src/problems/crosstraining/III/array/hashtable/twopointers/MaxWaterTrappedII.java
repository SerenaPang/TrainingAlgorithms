package problems.crosstraining.III.array.hashtable.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {

    /**
     * TC: O(mnlog(m+n))
     * SC: O(mn)
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
            //get all possible neighbor cells
            List<Element> neighborCells = getAllNeighbors(cur, matrix, visited);
            for (Element neighbor : neighborCells) {
                //ignore any visited neighbor cells
                if (visited[neighbor.rowIndex][neighbor.colIndex]) {
                    continue;
                }
                 // mark neigbor cell as visited, and put it to min heap
                visited[neighbor.rowIndex][neighbor.colIndex] = true;
                //how much water can be trapped at the neighbor cell controlled by the current height and neigbors height
                result = result + Math.max(cur.heightValue - neighbor.heightValue, 0);
                minHeap.offer(neighbor);
            }
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
        int rowIndex;
        int colIndex;
        int heightValue;

        Element(int row, int col, int height) {
            this.rowIndex = row;
            this.colIndex = col;
            this.heightValue = height;
        }

        @Override
        public int compareTo(Element another) {
            if (this.heightValue == another.heightValue) {
                return 0;
            }
            return this.heightValue < another.heightValue ? -1 : 1;
        }
    }

    /**
     * get all the neighboring cells of the element
     * */
    public List<Element> getAllNeighbors(Element cur, int[][] matrix, boolean[][] visited) {
        List<Element> neighberCells = new ArrayList<>();
        //add the element below the current element
        if (cur.rowIndex + 1 < matrix.length) {
            neighberCells.add(new Element(cur.rowIndex + 1, cur.colIndex, matrix[cur.rowIndex + 1][cur.colIndex]));
        }
        //add the element above the current element
        if (cur.rowIndex - 1 >= 0) {
            neighberCells.add(new Element(cur.rowIndex - 1, cur.colIndex, matrix[cur.rowIndex - 1][cur.colIndex]));
        }
        //add the element on the right side
        if (cur.colIndex + 1 < matrix[0].length) {
            neighberCells.add(new Element(cur.rowIndex, cur.colIndex + 1, matrix[cur.rowIndex][cur.colIndex + 1]));
        }
        //add the element on the left side
        if (cur.rowIndex - 1 >= 0) {
            neighberCells.add(new Element(cur.rowIndex, cur.colIndex - 1, matrix[cur.rowIndex][cur.colIndex - 1]));
        }
        return neighberCells;
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
