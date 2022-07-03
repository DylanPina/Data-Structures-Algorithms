package LeetCode.Neetcode150.SlidingWindow;
import java.util.HashSet;
/**
 * PROBLEM: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=wiGpQwVHdE0
 * BIG O: O(n)
 */
public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] charArr = s.toCharArray();
        int left = 0, res = 0;

        for (int right = 0; right < charArr.length; right++) {
            while (set.contains(charArr[right])) {
                set.remove(charArr[left]);
                left += 1;
            }
            set.add(charArr[right]);
            res = Math.max(res, set.size());
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
