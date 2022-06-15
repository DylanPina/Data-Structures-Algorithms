package LeetCode.Blind75.Geometry;
import java.util.ArrayList;
import java.util.List;
/**
 * PROBLEM: https://leetcode.com/problems/spiral-matrix/
 * SOLUTION: https://www.youtube.com/watch?v=BJnMZNwUk1M
 * BIG O: O(m * n)
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length - 1;   // TOP - BOTTOM
        int colStart = 0, colEnd = matrix[0].length - 1; // LEFT - RIGHT

        while (rowStart <= rowEnd && colStart <= colEnd) {
           // Traverse left to right
            for (int i = colStart; i <= colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;

            // Traverse top to bottom
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // Traverse right to left
                for (int i = colEnd; i >= colStart; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                // Traverse bottom to top
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(inputMatrix));
    }
}
