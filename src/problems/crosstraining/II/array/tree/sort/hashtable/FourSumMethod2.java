package problems.crosstraining.II.array.tree.sort.hashtable;

import java.util.Arrays;

public class FourSumMethod2 {
    /**Method 2: O(n^2 * logn), get all paiirs of numbers and apply 2 sum
     * sort the array first, and find i,j,k,l such that i<j<k<l, and the sum is the target
     *
     *split the tuple into 2 pair elements: (i,j) and (k,l)
     * so that array[i] + array[j] <= array[k] + array[l]
     */
    public boolean existII(int[] array, int target) {
        Arrays.sort(array);
        Element[] pairSum = getPairSum(array);
        Arrays.sort(pairSum);
        int left = 0;
        int right = pairSum.length - 1;
        //pair sum are sorted by sum, then right index, then left index
        while (left < right) {
            //only return true if two pair sums' sum is target and
            // the larger pair sum's left index > smaller pair sum's larger index
            if (pairSum[left].sum + pairSum[right].sum == target && pairSum[left].right < pairSum[right].left) {
                return true;
            } else if (pairSum[left].sum + pairSum[right].sum < target) {
                left++;
            } else {
                /**
                 * when 2 pair sums' sum > target, right --
                 * when two pair sums' sum == target but larger pair sum's left index <= smaller pair sum's right index,
                 * we need to do right-- because the only thing we can garantee is that now the smaller pair sum's right index
                 * is the smallest one among all the pair sums with the sam esum, and it is possible we can find another pair
                 * with smaller right index
                 * */
                right--;
            }
        }
        return false;
    }

    private Element[] getPairSum(int[] array) {
        Element[] pairSum = new Element[array.length * (array.length - 1) / 2];
        int curIndex = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                pairSum[curIndex++] = new Element(j, i, array[i] + array[j]);
            }
        }
        return pairSum;
    }

    /**
     * each element record a pair of numbers in the array
     * left: the smaller index of the pair of numbers
     * right: the larger index of the pair of numbers
     * sum: the sum of the pair of numbers
     * */
    static class Element implements Comparable<Element> {
        int left;
        int right;
        int sum;

        Element(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
        /**
         * we define the order of the element:
         * first by the sum value, then by the right index, then by the left index
         * */
        @Override
        public int compareTo(Element another) {
            if (this.sum != another.sum) {
                return this.sum < another.sum ? -1 : 1;
            } else if (this.right != another.right) {
                return this.right < another.right ? -1: 1;
            } else if(this.left != another.left) {
                return this.left < another.left ? -1 : 1;
            }
            return 0;
        }
    }
}
