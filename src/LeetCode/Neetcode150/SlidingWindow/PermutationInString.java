package LeetCode.Neetcode150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM: https://leetcode.com/problems/permutation-in-string/
 * SOLUTION: https://www.youtube.com/watch?v=UbyhOgBN834
 * BIG O: O(n)
 */
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (allZero(count)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private static boolean allZero(int[] count) {
        for (int num : count)
            if (num != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
