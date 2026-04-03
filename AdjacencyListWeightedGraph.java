package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListWeightedGraph {
    int vertices;
    boolean isDirected;
    List<List<Edge>> adjacencyList;

    public AdjacencyListWeightedGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int source, int destination) {
        addWeightedEdge(source, destination, 1);
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        if (!isDirected) {
            adjacencyList.get(destination).add(new Edge(source, weight));
        }
    }

    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).removeIf(edge -> edge.destination == destination);
        if (!isDirected) {
            adjacencyList.get(destination).removeIf(edge -> edge.destination == source);
        }
    }

    public boolean hasEdge(int source, int destination) {
        for (Edge edge : adjacencyList.get(source)) {
            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }

    public void getNeighbors(int vertex) {
        List<Edge> neighbors = adjacencyList.get(vertex);
        System.out.print("Neighbors of vertex " + vertex + ": ");
        if (neighbors.isEmpty()) {
            System.out.println("none");
            return;
        }
        for (Edge edge : neighbors) {
            System.out.print(edge.destination + "(w=" + edge.weight + ") ");
        }
        System.out.println();
    }

    public int getDegree(int vertex) {
        return adjacencyList.get(vertex).size();
    }

    public void displayList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print("[" + edge.destination + ", w=" + edge.weight + "] ");
            }
            System.out.println();
        }
    }
}