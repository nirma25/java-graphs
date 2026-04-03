package Graph;
import java.util.*;

public class GraphDFS {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public GraphDFS(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);  // Undirected graph
    }

    // DFS Recursive
    public void dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.println("\n📊 DFS Traversal (Recursive) starting from " + start + ":");
        dfsRecursiveHelper(start, visited, 0);
    }

    private void dfsRecursiveHelper(int vertex, boolean[] visited, int depth) {
        visited[vertex] = true;
        String indent = "  ".repeat(depth);
        System.out.println(indent + "→ Visiting " + vertex);

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                System.out.println(indent + "  Moving to neighbor " + neighbor);
                dfsRecursiveHelper(neighbor, visited, depth + 1);
            } else {
                System.out.println(indent + "  ↺ " + neighbor + " already visited");
            }
        }

        if (depth > 0) {
            System.out.println(indent + "← Backtracking from " + vertex);
        }
    }

    // DFS Iterative using Stack
    public void dfsIterative(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        System.out.println("\n📊 DFS Traversal (Iterative) starting from " + start + ":");

        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.println("  Visiting " + vertex);

                // Push neighbors in reverse order to simulate recursive order
                List<Integer> neighbors = adjacencyList.get(vertex);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                        System.out.println("    Pushing " + neighbor + " to stack");
                    }
                }
            }
        }
    }

    // Find if path exists
    public boolean hasPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        return hasPathHelper(source, destination, visited);
    }

    private boolean hasPathHelper(int current, int destination, boolean[] visited) {
        if (current == destination) return true;

        visited[current] = true;

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor]) {
                if (hasPathHelper(neighbor, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(6);

        // Create a sample graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Graph structure:");
        System.out.println("    0");
        System.out.println("   / \\");
        System.out.println("  1   2");
        System.out.println(" / \\ /");
        System.out.println("3   4");
        System.out.println(" \\ /");
        System.out.println("  5\n");

        graph.dfsRecursive(0);

        graph.dfsIterative(0);

        System.out.println("\nPath from 0 to 5? " + graph.hasPath(0, 5));
        System.out.println("Path from 3 to 2? " + graph.hasPath(3, 2));
    }
}
