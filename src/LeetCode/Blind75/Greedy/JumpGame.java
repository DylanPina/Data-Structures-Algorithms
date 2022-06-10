package LeetCode.Blind75.Greedy;
/*
 * PROBLEM: https://leetcode.com/problems/jump-game/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=Yan0cv2cLy8
 * BIG O: O(n)
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= goalPost)
                goalPost = i;
        }

        return goalPost == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2, 3, 1, 1, 4})); // True
        System.out.println(canJump(new int[] {3, 2, 1, 0, 4})); // False
    }
}
