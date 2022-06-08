package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/unique-paths/
 * SOLUTION: https://www.youtube.com/watch?v=IlEsdxuD4lY
 * BIG O: O(n * m)
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill out last row
        for (int j = 0; j < n; j++) {
            dp[m-1][j] = 1;
        }

        // Fill out last column
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }

        // Apply algorithm
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
