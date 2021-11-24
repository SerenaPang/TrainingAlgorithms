package problems.crosstraining.three;

public class MaxWaterTrappedII {

    public int maxTrapped(int[][] matrix) {
        int result = 0;

        return result;
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
