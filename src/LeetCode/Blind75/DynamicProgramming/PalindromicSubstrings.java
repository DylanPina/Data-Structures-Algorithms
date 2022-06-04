package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/palindromic-substrings/
 * SOLUTION: https://www.youtube.com/watch?v=4RACzI5-du8
 * BIG O: O(n^2)
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindromes(s, i, i);
            res += countPalindromes(s, i, i + 1);
        }

        return res;
    }

    public static int countPalindromes(String s, int left, int right) {
        int count = 0;
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            count += 1;
            left -= 1;
            right += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
