package LeetCode.Neetcode150.SlidingWindow;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * PROBLEM: https://leetcode.com/problems/sliding-window-maximum/
 * SOLUTION: https://www.youtube.com/watch?v=DfljaUwZsOk
 * BIG O: O(n)
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null)
            return nums;

        // Base case
        if (nums.length == 0 || k == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        // Deque will store indices
        Deque<Integer> deque = new ArrayDeque<>();

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            // Pop out smaller values from the deque
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[windowEnd])
                deque.removeLast();

            deque.add(windowEnd);
            // Remove the left value from the window
            if (windowStart > deque.getFirst())
                deque.removeFirst();

            if (windowEnd - windowStart + 1 >= k) {
                result[windowStart] = nums[deque.getFirst()];
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i]+", ");
    }
}
