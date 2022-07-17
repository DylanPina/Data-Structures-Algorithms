package LeetCode.Neetcode150.Stacks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * PROBLEM: https://leetcode.com/problems/generate-parentheses/
 * SOLUTION: https://www.youtube.com/watch?v=s9fokUqJ76A
 * BIG O: O(n)
 */
public class GenerateParentheses {
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator itr = stack.iterator();
            String temp = "";
            while (itr.hasNext())
                temp += itr.next();
            res.add(temp);
        }

        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }

        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
