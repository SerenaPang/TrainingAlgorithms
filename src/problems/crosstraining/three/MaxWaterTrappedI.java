package problems.crosstraining.three;

public class MaxWaterTrappedI {
    /***
     * TC: O(n)
     * SC: O(1)
     * find the tallest of left wall and the tallest of right wall
     * and accumulate result on the way
     */
    public int maxTrapped(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int result = 0;
        int leftHighestWall = array[left];
        int rightHighestWall = array[right];
        while (left < right) {
            if (array[left] <= array[right]) {
                //the left biggest number is the left of array[left] since left advance in every iteration
                //which makes it the right wall, if in the case that right and left wall has a difference greater than 0,
                //then there are unit water trapped
                result = result + Math.max(0, leftHighestWall - array[left]);
                //here we keep updating the tallest wall
                leftHighestWall = Math.max(leftHighestWall, array[left]);
                left++;
            } else {
                //the right side is doing the ssame thing as left, it keeps updating the right highest wall
                //and right is advance to the left every iteration, so if there is a difference between right tallest with right
                //that means there is water trapped between the walls
                result = result + Math.max(0, rightHighestWall - array[right]);
                rightHighestWall = Math.max(rightHighestWall, array[right]);
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,2,4};
        MaxWaterTrappedI m = new MaxWaterTrappedI();
        int result = m.maxTrapped(arr);
        System.out.println("The maximum water trapped in the array is: " + result);
    }
}
