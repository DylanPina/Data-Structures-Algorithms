package LeetCode.Neetcode150.ArraysHashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * PROBLEM: https://leetcode.com/problems/group-anagrams/
 * SOLUTION: https://www.youtube.com/watch?v=vzdNOK2oB2E
 * BIG O: (m * n)
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] count = new char[26];
            for (char c : s.toCharArray())
                count[c - 'a'] += 1;
            String str = new String(count);
            map.computeIfAbsent(str, k -> new ArrayList<>());
            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
