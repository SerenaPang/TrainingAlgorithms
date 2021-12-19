package problems.recursion.sorting;
/**
 *  base cases:
 *  b is 0: we know that every number to the power of 0 is 1
 *  a is 0: 0 to the power of any number is 0
 *
 *  the biggest problem is a to the power of b
 *  a smaller problem is a to the power of b - 1
 *
 *  2 ^ 3 = 8 = 2 * 2 * 2
 *
 *  TC: O(b)
 *  SC: O(b)
 *
 * */
public class AtoThePowerOfb {
    public long power(int a, int b) {
        //base cases:
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        //we have to return the result of curretn level multiply with the last level's result
       return power(a, b - 1) * a;
    }

    /** how to optimize the time?
     *  every time we decrease b by 1 until it reaches the base case, and each time we are calling the recursion function
     *  which case a lot of extra space consumption on the call stack
     *
     *  so we can divide b by half in each recursion so that it will reduce the problem size by logb time
     *
     *  TC: O(logb)
     *  SC:O(logb)
     */
    public long powerII(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long half = powerII(a, b/2);
        return b % 2 == 0 ? half * half : half * half * a;
    }

    public static void main(String[] args) {
        int a = 2;
        //int b = 0;
        int b = 3;
        AtoThePowerOfb atoThePowerOfb = new AtoThePowerOfb();
       // long result = atoThePowerOfb.power(a,b);
        long result = atoThePowerOfb.power(-2,5);
        System.out.println(a + " to the power of " + b + " is " + result);
    }
}
