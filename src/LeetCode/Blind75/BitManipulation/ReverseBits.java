package LeetCode.Blind75.BitManipulation;
/**
 * PROBLEM: https://leetcode.com/problems/reverse-bits/
 * SOLUTION: https://www.youtube.com/watch?v=UcoN6UjAI64
 * BIG O: O(1)
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }
}
