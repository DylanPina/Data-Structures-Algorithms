package LeetCode.Neetcode150.Stacks;
import java.util.Stack;
/**
 * PROBLEM: https://leetcode.com/problems/daily-temperatures/
 * SOLUTION: https://www.youtube.com/watch?v=Fn9FtZbzdxg
 * BIG O: O(n)
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res  = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
                res[stack.peek()] = i - stack.pop();
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(temperatures);
        for (int temperature : result) System.out.print(temperature + " ");
        System.out.println();

        int[] temperatures2 = { 30, 40, 50, 60 };
        int[] result2 = dailyTemperatures(temperatures2);
        for (int temperature : result2) System.out.print(temperature + " ");
        System.out.println();

        int[] temperatures3 = { 30, 60, 90 };
        int[] result3 = dailyTemperatures(temperatures3);
        for (int temperature : result3) System.out.print(temperature + " ");
    }
}
