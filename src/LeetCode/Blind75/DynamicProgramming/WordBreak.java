package LeetCode.Blind75.DynamicProgramming;
import java.util.*;
/*
 * PROBLEM: https://leetcode.com/problems/word-break/
 * SOLUTION: https://www.youtube.com/watch?v=Sx9NNgInc3A
 * BIG O: O(n * m * n)
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        // Create a cache
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode",wordDict));
    }
}
