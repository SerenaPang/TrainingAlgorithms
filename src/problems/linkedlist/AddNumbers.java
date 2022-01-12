package problems.linkedlist;

public class AddNumbers {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //add numbers without carry
    public static int[] addI(int[] arr1, int[] arr2) {
        int[] resArr = new int[arr1.length];
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            result = arr1[i] + arr2[i];
            resArr[i] = result;
        }
        return resArr;
    }

    //ad numbers with carry
    public static int[] addII(int[] arr1, int[] arr2) {
        int[] resArr = new int[arr1.length];
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            result = result + arr1[i];
            result = result + arr2[i];
            int res = result % 10;
            resArr[i] = res;
            System.out.println("res: " + res);
            result = result / 10;

        }
        return resArr;
    }
    /**
     * add the numbers together and put the result to an array
     *
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3};
        int[] arr2 = new int[]{4,5,2};
        //5 0 7
        print(arr);
        print(arr2);
        int[] resArr1 = addII(arr,arr2);
        print(resArr1);

    }
}
