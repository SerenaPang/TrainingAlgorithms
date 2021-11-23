package problems.crosstraining.three;

public class MergeKSortedArray {

    public int[] merge(int[][] arrayOfArrays) {
        int[] result = new int[arrayOfArrays.length];


        return result;
    }

    public void printTwoDimentionalArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeKSortedArray m = new MergeKSortedArray();
        int[][] a = new int[][]{
                {3},
                {1,2,3,4,5}
        };
        m.printTwoDimentionalArr(a);

    }
}
