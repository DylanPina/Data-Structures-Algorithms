package LeetCode.Blind75.Greedy;
/*
 * PROBLEM: https://leetcode.com/problems/maximum-subarray/
 * SOLUTION: https://www.youtube.com/watch?v=5WZl3MMT0Eg
 * BIG O: O(n)
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }

        return maxSub;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
