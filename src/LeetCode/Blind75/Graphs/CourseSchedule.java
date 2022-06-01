package LeetCode.Blind75.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * PROBLEM: https://leetcode.com/problems/course-schedule/
 * SOLUTION: https://www.youtube.com/watch?v=EgI5nU9etnU
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjacency matrix of graph
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        // Fill all the nodes (0 to numCourses - 1) as array index holding newly created arraylists
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        // Fill the array lists of each node with their outgoing edges/connected nodes
        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }
        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's
        int[] visited = new int[numCourses];
        // Do DFS for each of the array nodes to check a cycle
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, adj))
                return false;
        }

        return true;
    }

    public static boolean dfs(int node, int[] visited, ArrayList<Integer>[] adj) {
        // Return false if the node is visited and viewed again before completion
        if (visited[node] == 1) {
            return false;
        }
        // Return true if the node is completed processing
        if (visited[node] == 2) {
            return true;
        }
        // Mark the node as visited
        visited[node] = 1;
        // DFS of all the other nodes current "node" is connected to
        for(int n : adj[node]) {
            if(!dfs(n, visited, adj))
                return false;
        }
        // If no more other nodes for the current "node" mark as completed and return true
        visited[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] preReq = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        int[][] preReq2 = {{0, 1}, {1, 2}, {2, 0}};

        System.out.println(canFinish(5, preReq));
        System.out.println(canFinish(3, preReq2));
    }

}

