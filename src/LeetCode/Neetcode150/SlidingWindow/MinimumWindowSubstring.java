package LeetCode.Neetcode150.SlidingWindow;
import java.util.HashMap;
/**
 * PROBLEM: https://leetcode.com/problems/minimum-window-substring/
 * SOLUTION: https://www.youtube.com/watch?v=jSto0O4AJbM
 * BIG O: O(n)
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t == "") return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int matched = 0, start = 0, minLen = s.length() + 1, subStr = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0)
                    matched++;
            }

            while (matched == map.size()) {
                if (minLen > windowEnd - start + 1) {
                    minLen = windowEnd - start + 1;
                    subStr = start;
                }
                char removed = s.charAt(start++);
                if (map.containsKey(removed)) {
                    if (map.get(removed) == 0)
                        matched--;
                    map.put(removed, map.get(removed) + 1);
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
