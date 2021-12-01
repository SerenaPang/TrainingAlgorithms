package problems.crosstraining.IV.array.hashtable.linkedlist.math;

public class MajorityNumberI {
    /**
     * TC: O(n)
     * SC: O(1)
     * */
    public int majority(int[] array) {
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count++;
                candidate = array[i];
            } else if (candidate == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,1,2,1};
        MajorityNumberI m = new MajorityNumberI();
        m.majority(A);
    }
}
