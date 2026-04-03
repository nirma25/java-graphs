package Graph;

import java.util.*;

public class GraphBFS {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public GraphBFS(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    // BFS Iterative using Queue
    public void bfsIterative(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("\nBFS Traversal (Iterative) starting from " + start + ":");

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("  Visiting " + vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    System.out.println("    Queuing neighbor " + neighbor);
                } else {
                    System.out.println("    " + neighbor + " already visited");
                }
            }
        }
    }

    // BFS Level by Level — shows which level each node is on
    public void bfsLevelOrder(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("\nBFS Level Order starting from " + start + ":");

        visited[start] = true;
        queue.offer(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // how many nodes are on this level
            System.out.print("  Level " + level + ": ");

            for (int i = 0; i < levelSize; i++) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                for (int neighbor : adjacencyList.get(vertex)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            System.out.println();
            level++;
        }
    }

    // Find shortest path using BFS (unweighted graph)
    public void shortestPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices]; // tracks how we got to each node
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (vertex == destination) {
                break;
            }

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = vertex;
                    queue.offer(neighbor);
                }
            }
        }

        // Reconstruct path by walking back through parent array
        if (!visited[destination]) {
            System.out.println("\nNo path from " + source + " to " + destination);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = destination; v != -1; v = parent[v]) {
            path.add(v);
        }

        Collections.reverse(path);
        System.out.print("\nShortest path from " + source + " to " + destination + ": ");
        for (int i = 0; i < path.size(); i++) {
            if (i < path.size() - 1) {
                System.out.print(path.get(i) + " -> ");
            } else {
                System.out.print(path.get(i));
            }
        }
        System.out.println(" (length: " + (path.size() - 1) + ")");
    }

    // Check if path exists using BFS
    public boolean hasPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (vertex == destination) return true;

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(6);

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
        System.out.println("  5");

        graph.bfsIterative(0);

        graph.bfsLevelOrder(0);

        graph.shortestPath(0, 5);
        graph.shortestPath(3, 2);
        graph.shortestPath(0, 3);

        System.out.println("\nhasPath(0, 5): " + graph.hasPath(0, 5));
        System.out.println("hasPath(3, 2): " + graph.hasPath(3, 2));
    }
}