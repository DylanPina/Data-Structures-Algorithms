package LeetCode.Neetcode150.TwoPointers;
/**
 * PROBLEM: https://leetcode.com/problems/trapping-rain-water/
 * SOLUTION: https://www.youtube.com/watch?v=ZI2z5pq0TqA
 * BIG O: O(n)
 */
public class TrappingRainWater {

    // O(n) memory solution
    public static int trap(int[] height) {
        if (height.length == 0) return 0;
        // Initialize arrays for max left, max right, and min(L,R)
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLeftRight = new int[height.length];

        // Store the max left for every height
        for (int i = 0; i < height.length; i++) {
            if (i == 0)
                maxLeft[i] = 0;
            else
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        // Store the max right for every height
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1)
                maxRight[i] = 0;
            else {
                maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
            }
        }

        // Store the minimum of left and right for every height
        for (int i = 0; i < height.length; i++)
            minLeftRight[i] = Math.min(maxLeft[i], maxRight[i]);

        // Compute the most water that can be trapped for every height and add to result
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int unitsOfWater = minLeftRight[i] - height[i];
            if (unitsOfWater < 0)
                res += 0;
            else
                res += unitsOfWater;
        }

        return res;
    }

    // O(1) memory
    public static int trap2(int[] height) {
        if (height.length == 0) return 0;
        // Initialize left and right pointers
        int left = 0, right = height.length - 1;
        // Initialize max left and max right
        int leftMax = height[left], rightMax = height[right];
        // Initialize a result variable
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left += 1;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right -= 1;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap2(height1));
    }
}
