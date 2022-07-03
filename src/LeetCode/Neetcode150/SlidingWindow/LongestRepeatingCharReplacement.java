package LeetCode.Neetcode150.SlidingWindow;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * PROBLEM: https://leetcode.com/problems/longest-repeating-character-replacement/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=gqXU1UyA8pk
 * BIG O: O(n)
 */
public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int res = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char end = s.charAt(windowEnd);
            charCount.put(end, charCount.getOrDefault(end, 0) + 1);

            while ((windowEnd - windowStart + 1) - Collections.max(charCount.values()) > k) {
                char startChar = s.charAt(windowStart);
                charCount.put(startChar, charCount.get(startChar) - 1);
                windowStart += 1;
            }

            res = Math.max(res, windowEnd - windowStart + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement("AAAA", 2));
    }
}
