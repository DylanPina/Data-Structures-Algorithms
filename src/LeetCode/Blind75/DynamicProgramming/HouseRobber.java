package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/house-robber/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=73r3KWiEvyk
 * BIG 0:
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            int temp = Integer.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1, 2, 3, 1}));
        System.out.println(rob(new int[] {2,7,9,3,1}));
        System.out.println(rob(new int[] {1, 2, 3, 1, 1, 100}));
    }
}
