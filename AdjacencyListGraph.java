package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph {
    int vertices;
    boolean isDirected;
    List<List<Integer>> adjacencyList;

    public AdjacencyListGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        if (!isDirected) {
            adjacencyList.get(destination).remove(Integer.valueOf(source));
        }
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    public void getNeighbors(int vertex) {
        System.out.print("Neighbors of vertex " + vertex + ": ");
        if (adjacencyList.get(vertex).isEmpty()) {
            System.out.println("none");
            return;
        }
        for (int neighbor : adjacencyList.get(vertex)) {
            System.out.print(neighbor + " ");
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
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}