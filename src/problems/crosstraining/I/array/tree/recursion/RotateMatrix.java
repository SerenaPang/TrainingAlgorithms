package problems.crosstraining.I.array.tree.recursion;

public class RotateMatrix {
    public static int[][] rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        int n = matrix.length;
        if (n <= 1) {
            return result;
        }

        for (int r = 0, c = n - 1; r < n; r++,c--) {
            for (int i = 0; i < n; i++) {
                result[i][c] = matrix[r][i];
            }
        }
        //
        return result;
    }

    public static int[][] rotate1(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        int n = matrix.length;
        if (n <= 1) {
            return result;
        }
        for (int r = 0, nc = n - 1; r < n; r++, nc--) {
            for (int c = 0; c < n; c++) {
                result[c][nc] = matrix[r][c];
            }
        }
        return result;
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        int tmpLeftUpper = matrix[0][0];
        matrix[0][0] = matrix[1][0];
        matrix[1][0] = matrix[1][1];
        matrix[1][1] = matrix[0][1];
        matrix[0][1] = tmpLeftUpper;
    }



    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix2 = new int[][]{
                {1,2},
                {3,4}
        };

        int[][] matrix3 = new int[][]{
                {1,2,3},
                {8,9,4},
                {7,6,5}
        };

        int[][] matrix4 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int[][] matrix5 = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };


        int[][] matrix8 = new int[][]{
                {1,  2,  3,  4,    5,  6,  7, 8},
                {9,  10, 11, 12,  14, 15, 16, 17},
                {18, 19, 20, 21,  22, 23, 24, 25},
                {26, 27, 28, 29,  30, 31, 32, 33},
                {34, 35, 36, 37,  38, 39, 40, 41},
                {42, 43, 44, 45,  46, 47, 48, 49},
                {50, 51, 52, 53,  54, 55 ,56, 57},
                {58, 59, 60, 61,  62, 63, 64, 65}
        };

        print(matrix4);
        System.out.println("Rotate matrix:");

        rotate2(matrix4);
        print(matrix4);
    }
}
