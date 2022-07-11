package LeetCode.Neetcode150.Stacks;
import java.util.HashMap;
import java.util.Stack;
/**
 * PROBLEM: https://leetcode.com/problems/valid-parentheses/
 * SOLUTION: https://www.youtube.com/watch?v=WTzjTskDFMg
 * BIG O: O(n)
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch))
                stack.push(ch);
            else if (stack.isEmpty() || map.get(stack.pop()) != ch)
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(}"));
    }
}
