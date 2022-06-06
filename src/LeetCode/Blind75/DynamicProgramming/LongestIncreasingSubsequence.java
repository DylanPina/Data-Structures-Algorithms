package LeetCode.Blind75.DynamicProgramming;
import java.util.Arrays;
/*
 * PROBLEM: https://leetcode.com/problems/longest-increasing-subsequence/
 * SOLUTION: https://www.youtube.com/watch?v=cjWnW0hdF1Y
 * BIG O: O(n^2)
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength,1);
        int maximumSoFar = 1;

        for (int j = 1; j < nums.length; j++) {
            int i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    maxLength[j] = Math.max(1 + maxLength[i], maxLength[j]);
                }
                i++;
            }
            maximumSoFar = Math.max(maximumSoFar, maxLength[j]);
        }
        return maximumSoFar;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
