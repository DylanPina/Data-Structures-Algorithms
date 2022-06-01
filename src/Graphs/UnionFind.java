package Graphs;
/*
 * EXPLANATION: https://www.youtube.com/watch?v=4avlWhSdM2I
 * - Keeps track of elements that are in the non-overlapping disjoint subsets
 * - FindParent(x): Find the root node of a cluster
 * - Union(x, y): Merge two clusters
 */
public class UnionFind {
    private int[] parents;
    private int[] size;
    int numOfComponents;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponents = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int curr) {
        int root = curr;
        while (root != parents[root])
            root = parents[root];

        // Path compression
        while (curr != root) {
            int prevParent = parents[curr];
            parents[curr] = root;
            curr = prevParent;
        }
        return root;
    }

    public int findComponentSize(int curr) {
        int parent = findParent(curr);
        return size[parent];
    }

    public void union(int node1, int node2) {
        int node1Parent = findParent(node1);
        int node2Parent = findParent(node2);

        if (node1Parent == node2Parent)
            return;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponents--;
    }
}
