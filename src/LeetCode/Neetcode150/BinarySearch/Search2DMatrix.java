package LeetCode.Neetcode150.BinarySearch;
import java.util.Arrays;
/**
 * PROBLEM: https://leetcode.com/problems/search-a-2d-matrix/
 * SOLUTION: https://www.youtube.com/watch?v=Ber2pi2C0j0
 * BIG O: O(logm + logn)
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int lrow = 0, rrow = matrix.length - 1, n = 0;

        while (lrow < rrow) {
            n = (lrow + rrow) / 2;
            if (matrix[n][0] > target) rrow = n;
            else if (matrix[n][matrix[0].length - 1] < target)
                lrow = n + 1;
            else break;
        }

        if (Arrays.binarySearch(matrix[(lrow + rrow) / 2], target) >= 0)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{ 1, 3, 5, 7 }, { 10, 11, 16, 20 }};
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }
}
