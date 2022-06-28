package LeetCode.Neetcode150.ArraysHashing;
import java.util.HashMap;
/**
 * PROBLEM: https://leetcode.com/problems/longest-consecutive-sequence/
 * SOLUTION: https://www.youtube.com/watch?v=P6RZZMu_maU
 * BIG O: O(n)
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, true);
        }
        int longest = 0;

        for (int n: nums) {
            if (!map.get(n)) {
                continue;
            }
            map.put(n, false);
            int current = 1;
            int left = n - 1;
            int right = n + 1;
            while(map.containsKey(left)) {
                map.put(left, false);
                left--;
                current++;
            }
            while(map.containsKey(right)) {
                map.put(right, false);
                right++;
                current++;
            }
            if (current > longest){
                longest = current;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }
}
