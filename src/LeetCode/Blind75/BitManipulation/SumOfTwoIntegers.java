package LeetCode.Blind75.BitManipulation;
/**
 * PROBLEM: https://leetcode.com/problems/sum-of-two-integers/
 * SOLUTION: https://www.youtube.com/watch?v=gVUrDV4tZfY
 * BIG O: O(1)
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }
}
