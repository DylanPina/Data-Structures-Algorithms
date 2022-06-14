package LeetCode.Blind75.Geometry;
/**
 * PROBLEM: https://leetcode.com/problems/rotate-image/
 * SOLUTION: https://www.youtube.com/watch?v=fMSJSS7eO1w
 * BIG O: O(n^2)
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;
                // Save top left value
                int topLeft = matrix[top][left + i];
                // Move bottom left into top left
                matrix[top][left + i] = matrix[bottom - i][left];
                // Move bottom right into bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];
                // Move top right into bottom right
                matrix[bottom][right - i] = matrix[top + i][right];
                // Move rop left into top right
                matrix[top + i][right] = topLeft;
            }
            left += 1;
            right -= 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix1);
    }
}
