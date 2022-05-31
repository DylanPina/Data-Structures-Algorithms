package LeetCode.Blind75.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * PROBLEM: https://leetcode.com/problems/pacific-atlantic-water-flow/
 * SOLUTION: https://www.youtube.com/watch?v=s-VkcjHqkGI
 */
public class PacificAtlanticWaterFlow {

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int ROWS = matrix.length, COLS = matrix[0].length;
        // Create a visited map for each ocean
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // DFS on top and left and right columns
        for (int i = 0; i < ROWS; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, COLS - 1);
        }

        // DFS on left and right rows
        for (int i = 0; i < COLS; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, ROWS - 1, i);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[] {i, j});
            }
        }

        return res;
    }

    public static void dfs(int[][] matrix, boolean[][] visited, int height, int r, int c) {
        int ROW = matrix.length, COL = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if (r < 0 || r >= ROW || c < 0 || c >= COL || visited[r][c] || matrix[r][c] < height) {
            return;
        }

        visited[r][c] = true;
        for (int[] direction : directions)
            dfs(matrix, visited, matrix[r][c], r + direction[0], c + direction[1]);
    }


    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5},
                           {3, 2, 3, 4, 4},
                           {2, 4, 5, 3, 1},
                           {6, 7, 1, 4, 5},
                           {5, 1, 1, 2, 4}};

        List<int[]> result = pacificAtlantic(heights);

        for (int[] x : result) {
            System.out.print(x[0] + " " + x[1] + "\n");
        }
    }
}
