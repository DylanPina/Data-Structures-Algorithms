package LeetCode.Blind75.DynamicProgramming;
/*
 * PROBLEM: https://leetcode.com/problems/climbing-stairs/
 * SOLUTION: https://www.youtube.com/watch?v=Y0lT9Fck7qI
 * BIG O: O(n)
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        int one = 1, two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one += two;
            two = temp;
        }
        
        return one;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
