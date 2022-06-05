package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/maximum-product-subarray/
 * SOLUTION: https://www.youtube.com/watch?v=lXVy6YWFcRM
 * BIG O: O(n)
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currMin = 1, currMax = 1;

        for (int n : nums) {
            int temp = currMax * n;
            currMax = Math.max(n * currMax, n * currMin);
            currMax = Math.max(currMax, n);
            currMin = Math.min(temp, n * currMin);
            currMin = Math.min(currMin, n);
            res = Math.max(res, currMax);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    }
}
