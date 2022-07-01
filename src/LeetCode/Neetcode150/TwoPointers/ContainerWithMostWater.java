package LeetCode.Neetcode150.TwoPointers;
/**
 * PROBLEM: https://leetcode.com/problems/container-with-most-water/
 * SOLUTION: https://www.youtube.com/watch?v=UuiTKBwPgAo
 * BIG O: O(n)
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(heights));
    }
}
