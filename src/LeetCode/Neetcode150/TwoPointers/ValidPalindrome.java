package LeetCode.Neetcode150.TwoPointers;
/**
 * PROBLEM: https://leetcode.com/problems/valid-palindrome/
 * SOLUTION: https://www.youtube.com/watch?v=jJXJ16kPFWg
 * BIG O: O(n)
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (Character.isLetterOrDigit(s.charAt(i)))
                content.append(s.charAt(i));
        content = new StringBuilder(content.toString().toLowerCase());
        String value = content.toString();
        return value.equals(content.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("race a car"));
    }
}
