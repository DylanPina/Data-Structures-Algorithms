package LeetCode.Neetcode150.ArraysHashing;
import java.util.HashSet;
/**
 * PROBLEM: https://leetcode.com/problems/valid-sudoku/
 * SOLUTION: https://www.youtube.com/watch?v=TjFXEUCMqI8
 * BIG O: O(n)
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // Check whether HashSet contains duplicate elements in row and column
                    if (h1.contains("row" + i + board[i][j]) ||  h1.contains("col" + j + board[i][j]))
                        return false;
                    h1.add("row" + i + board[i][j]);
                    h1.add("col" + j + board[i][j]);

                    // Check whether 3x3 box contains duplicate elements
                    if (h1.contains("box" + (i / 3) + (j / 3) + board[i][j]))
                        return false;
                    h1.add("box" + (i / 3) + (j / 3) + board[i][j]);
                }
            }
        }
        return true;
    }
}
