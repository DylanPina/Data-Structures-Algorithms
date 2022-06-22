package LeetCode.Needcode150.ArraysHashing;
import java.util.HashSet;
/**
 * PROBLEM: https://leetcode.com/problems/contains-duplicate/
 * SOLUTION: https://www.youtube.com/watch?v=TjFXEUCMqI8
 * BIG O: O(n)
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
    }
}
