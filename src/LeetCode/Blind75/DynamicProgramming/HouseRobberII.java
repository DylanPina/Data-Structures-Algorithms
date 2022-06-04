package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/house-robber-ii/
 * SOLUTION: https://www.youtube.com/watch?v=rWAJCfYYOvM
 * BIG O: O(n)
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public static int helper(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3}));
    }
}
