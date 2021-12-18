package problems.recursion.sorting;
/**
 * get the kth fibonacci number:
 * result = f(n-1) + f(n-2) is valid for n > 2
 * the current result is the sum of previous two Fibonacci sequence number
 * f0: 0
 * f1: 1
 * f2: 1
 * f3 : 2
 * f4: 3
 *
 * TC: O(2^k), k  is the kth fibonacci number it asked for
 * SC: O(k),k level of recursion function call on stack
 * */
public class FibonacciNumberLite {
    /**
     *  k is the biggest problem, a smaller problem is k - 1, until k reaches 0
     *  in Fibonacci, we know that in f0,1,2, the results are 0, 1, 1
     *
     *  how to compute the current kth fibonacci sequence?
     *  f(n-1) + f(n-2)
     *
     *  for each kth fibonacci number, we need to know the previous 2 fibonacci, number
     *  so we need to return the result of the current Fibonacci result to the previous level
     * */
    public int fibonacci(int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1 || k == 2) {
            return 1;
        }
        return fibonacci(k-1) + fibonacci(k - 2);
    }
}
