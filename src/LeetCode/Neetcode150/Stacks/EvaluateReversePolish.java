package LeetCode.Neetcode150.Stacks;
import java.util.Stack;
/**
 * PROBLEM: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * SOLUTION: https://www.youtube.com/watch?v=iu0082c4HDE&t=6s
 * BIG O: O(n)
 */
public class EvaluateReversePolish {

    public static int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
    }
}
