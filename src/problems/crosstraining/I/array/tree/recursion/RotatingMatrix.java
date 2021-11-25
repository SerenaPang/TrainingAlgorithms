package problems.crosstraining.I.array.tree.recursion;


/**
 * Problem
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 *
 * How to approach the problem? First, draw the matrix:
 *
 *   X00 X01 X02 X03 X04
 *   X10 X11 X12 X12 X14
 *   X20 X21 X22 X22 X24
 *   X30 X31 X32 X32 X34
 *   X40 X41 X42 X43 X44
 *
 * if we rotate this matrix we have:
 *
 *   X40 X30 X20 X10 X00
 *   X41 X31 X21 X11 X01
 *   X42 X32 X22 X12 X02
 *   X43 X33 X23 X13 X03
 *   X44 X34 X24 X14 X04
 *
 * One way to perform the rotation is to start changing the corners of the matrix and then
 * the inner elements, so we change the elements X00, X04, X44, X40 and then the inner
 * elements {01, 14, 43, 30}, {02, 24, 42, 20} and {03, 34, 41, 10}. So we need to generate
 * the following sequence of indexes in order to perform the rotation:
 *
 * First iteration of the outer loop
 *     First iteration of the inner loop
 *       00
 *       04
 *       44
 *       40
 *     Second iteration of the inner loop
 *       01
 *       14
 *       43
 *       30
 *     Third iteration of the inner loop
 *       02
 *       24
 *       42
 *       20
 *     Four iteration of the inner loop
 *       03
 *       34
 *       41
 *       10
 *
 * Second iteration of the outer loop
 *     First iteration of the inner loop
 *       11
 *       13
 *       33
 *       31
 *     Second iteration of the inner loop
 *       12
 *       23
 *       32
 *       21
 *
 * Once we have generated this sequence, we can implement the interchanging of the elements.
 *
 */

public class RotatingMatrix {

    public static void print(int matrix[][]) {
        for (int vector[] : matrix) {
            for (int value : vector) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void rotate(int matrix[][]) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {

                System.out.println("here");
	      System.out.println(i + " " + j);
	      System.out.println(j  + " " + (matrix.length - 1 - i));
	      System.out.println((matrix.length - 1 - i) + " " + (matrix.length - 1 - j));
	      System.out.println((matrix.length - 1 - j) + " " + i);
	      System.out.println();
	      System.out.println("...");

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix. length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = tmp;
            }
        }
    }


    public static void main(String[] args) {


        int matrix1[][] = {
                {1,   2,  3,  4,  5,  6},
                {7,   8,  9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        int[][] matrix = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println("Original Matrix");
        print(matrix);

        System.out.println("Matrix Rotated 90 degrees");
        rotate(matrix);
        print(matrix);
    }
}


