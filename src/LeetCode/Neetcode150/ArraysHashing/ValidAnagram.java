package LeetCode.Neetcode150.ArraysHashing;
/**
 * PROBLEM: https://leetcode.com/problems/valid-anagram/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=9UtInBqnCgA&feature=youtu.be
 * BIG O: O(n)
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] store = new int[26];

        for(int i=0; i<s.length(); i++){
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for(int n:store)
            if(n != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
