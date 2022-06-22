package LeetCode.Neetcode150.ArraysHashing;
import java.util.HashMap;
/**
 * PROBLEM: https://leetcode.com/problems/two-sum/
 * SOLUTION: https://www.youtube.com/watch?v=KLlXCFG5TnA
 * BIG O: O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                res[0] = map.get(difference);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
