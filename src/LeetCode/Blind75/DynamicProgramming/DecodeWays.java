package LeetCode.Blind75.DynamicProgramming;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
 * PROBLEM: https://leetcode.com/problems/decode-ways/submissions/
 * SOLUTION: https://www.youtube.com/watch?v=6aEyTjOwlJU
 * BIG O: O(n)
 */
public class DecodeWays {
    private static final List<String> LETTERS =
            IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());
    public static int numDecodings(String digits) {
        if (digits.isEmpty()) return 0;
        return dfs(0, new int[digits.length()], digits);
    }

    private static int dfs(int i, int[] memo, String digits) {
        if (i == digits.length()) return 1;
        if (memo[i] != 0) return memo[i];

        int ways = 0;
        for (String prefix : LETTERS) {
            if (digits.substring(i).startsWith(prefix)) {
                ways += dfs(i + prefix.length(), memo, digits);
            }
        }
        memo[i] = ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));
    }
}
