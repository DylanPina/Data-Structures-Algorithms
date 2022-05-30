package Graphs;
import java.util.*;

class Vertex<T> {
    private final T data;
    private boolean visited;
    private List<Vertex<T>> neighbors = new ArrayList<>();

    public Vertex(T data, boolean visited, List<Vertex<T>> neighbors) {
        this.data = data;
        this.visited = visited;
        this.neighbors = neighbors;
    }

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex<T>> getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor) {
        this.neighbors.add(neighbor);
    }

    public void setNeighbors(List<Vertex<T>> neighbors) {
        this.neighbors = neighbors;
    }


    public String toString() {
        return this.data.toString();
    }

}

class DepthFirstSearch<T> {

    public void traverseIterative(Vertex<T> startVertex) {
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();

            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.print(current + " ");

                for (Vertex<T> v : current.getNeighbors())
                   stack.push(v);
            }
        }
    }

    public void traverseRecursively(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.print(vertex + " ");

        for (Vertex<T> v : vertex.getNeighbors()) {
            if (!v.isVisited()) {
                traverseRecursively(v);
            }
        }
    }

}

class BreadthFirstSearch<T> {
    public void traverse(Vertex<T> startVertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.print(current + " ");
                queue.addAll(current.getNeighbors());
            }
        }
    }

}

class Traversals {

    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.addNeighbor(v0);

        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>();

        System.out.println("ITERATIVE: Depth First Search: ");
        dfs.traverseIterative(v1);
        clearVisited(Arrays.asList(v0, v1, v2, v3, v4, v5,v6));

        System.out.println("\nRECURSIVE: Depth First Search: ");
        dfs.traverseRecursively(v1);
        clearVisited(Arrays.asList(v0, v1, v2, v3, v4, v5,v6));

        System.out.println("\nRECURSIVE: Breadth First Search: ");
        bfs.traverse(v1);
        clearVisited(Arrays.asList(v0, v1, v2, v3, v4, v5,v6));

    }

    public static <T> void clearVisited(List<Vertex<T>> vertices) {
        for (Vertex<T> v : vertices) {
            v.setVisited(false);
        }
    }

}
