package LeetCode.Blind75.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n == 0)
            return true;

        HashMap<Integer, List<Integer>> adjList = buildAdjListUndirected(edges);
        HashSet<Integer> visited = new HashSet<>(n);

        dfs()
    }

    public boolean dfs(HashMap<Integer, List<Integer>> adjacencyList, HashSet<Integer> visited,
                       int i, int prev) {

        if (visited.contains(i))
            return false;

        visited.add(i);
        for (int vertex : adjacencyList.get(i)) {
            if (vertex == prev)
                continue;
            dfs(vertex,)
        }
    }

    public static HashMap<Integer, List<Integer>> buildAdjListUndirected(int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

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
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        System.out.println(buildAdjListUndirected(edges));
        System.out.println(buildAdjListUndirected(edges2));
    }

}
