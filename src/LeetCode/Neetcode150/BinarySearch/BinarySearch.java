package LeetCode.Neetcode150.BinarySearch;
/**
 * PROBLEM: https://leetcode.com/problems/binary-search/
 * SOLUTION: https://www.youtube.com/watch?v=s4DPM8ct1pI
 * BIG O: O(logn)
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));
        System.out.println(search(nums, 2));
    }
}
