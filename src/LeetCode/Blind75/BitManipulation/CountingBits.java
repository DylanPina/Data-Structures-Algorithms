package LeetCode.Blind75.BitManipulation;

import java.util.Arrays;

/**
 * PROBLEM: https://leetcode.com/problems/counting-bits/
 * SOLUTION: https://www.youtube.com/watch?v=RyBM56RIWrM
 * BIG O: O(n)
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, 0);
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i)
                offset = i;
            ans[i] = 1 + ans[i - offset];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] answer = countBits(5);

        for (int x : answer)
            System.out.print(x + " ");
    }
}
