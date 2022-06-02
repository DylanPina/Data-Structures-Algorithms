package LeetCode.Blind75.Graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/*
 * PROBLEM: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * SOLUTION: https://www.youtube.com/watch?v=8f1XPm4WOUc
 */
public class NumberOfConnectedComponents {

    public static int countComponents(int n, int[][] edges) {
        int count = 0;
        if (n == 0) return count;

        HashMap<Integer, List<Integer>> graph = buildUndirectedGraph(edges);
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, visited, i);
            }
        }
        return count;
    }

    public static void dfs(HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, int curr) {
        visited.add(curr);
        for (Integer neighbor : graph.get(curr))
            if (!visited.contains(neighbor))
                dfs(graph, visited, neighbor);
    }

    public static HashMap<Integer, List<Integer>> buildUndirectedGraph(int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        if (edges.length == 0) return adjList;

        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];

            if (!adjList.containsKey(v1))
                adjList.put(v1, new ArrayList<>());
            if (!adjList.containsKey(v2))
                adjList.put(v2, new ArrayList<>());

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        System.out.println(countComponents(5, edges));
    }
}
