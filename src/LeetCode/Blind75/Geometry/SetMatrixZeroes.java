package LeetCode.Blind75.Geometry;
/**
 * PROBLEM: https://leetcode.com/problems/set-matrix-zeroes/
 * SOLUTION: https://www.youtube.com/watch?v=T41rL0L3Pnw
 * BIG O: O(m * n)
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean rowZero = false;

        // Determine which rows & cols need to be zero
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    if (r > 0)
                        matrix[r][0] = 0;
                    else
                        rowZero = true;
                }
            }
        }
        // Go through every position one more time and zero it out BESIDES first row & col
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0)
                    matrix[r][c] = 0;
            }
        }
        // Check if we need to zero out last column
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++)
                matrix[r][0] = 0;
        }
        // Check out rowZero variable
        if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        System.out.println("Before: ");
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                System.out.print(matrix[r][c] + " ");

        setZeroes(matrix);
        System.out.println("\nAfter: ");
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++)
                System.out.print(matrix[r][c] + " ");
    }
}
