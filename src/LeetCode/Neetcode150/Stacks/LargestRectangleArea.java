package LeetCode.Neetcode150.Stacks;
import java.util.Stack;
/**
 * PROBLEM: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * SOLUTION: https://www.youtube.com/watch?v=zx5Sw9130L0
 * BIG O: O(n)
 */
public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, i = 0, max = 0;

        Stack<Integer> stack = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }
            // put current bar's index to the stack
            stack.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!stack.isEmpty()) {
            max = Math.max(max, heights[stack.pop()] * (n - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));

    }
}
