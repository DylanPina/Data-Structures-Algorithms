package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/longest-common-subsequence/
 * SOLUTION: https://www.youtube.com/watch?v=Ua0GhsJSlWM
 * BIG O: O(n * m)
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // fill out 0 for empty strings comparison for all rows
        for (int i =0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        // fill out 0 for empty strings comparison for all columns
        for (int j =0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "abc"));
    }
}
