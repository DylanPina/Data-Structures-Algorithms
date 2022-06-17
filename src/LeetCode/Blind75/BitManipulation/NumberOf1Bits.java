package LeetCode.Blind75.BitManipulation;
/**
 * PROBLEM: https://leetcode.com/problems/number-of-1-bits/
 * SOLUTION: https://www.youtube.com/watch?v=5Km3utixwZs&ab_channel=NeetCode
 * BIG O: O(1)
 */
public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
