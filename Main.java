package Graph;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // --- Adjacency Matrix Graph ---
        System.out.println("=== Adjacency Matrix Graph ===");
        AdjacencyMatrixGraph matrixGraph = new AdjacencyMatrixGraph(4, false);

        matrixGraph.addEdge(0, 1);
        matrixGraph.addEdge(0, 2);
        matrixGraph.addEdge(1, 2);
        matrixGraph.addWeightedEdge(2, 3, 3);

        matrixGraph.displayMatrix();

        // --- Adjacency List Graph (unweighted) ---
        System.out.println("\n=== Adjacency List Graph Undirected ===");
        AdjacencyListGraph listGraph = new AdjacencyListGraph(5, false);

        listGraph.addEdge(0, 1);
        listGraph.addEdge(0, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(2, 4);
        listGraph.addEdge(3, 4);
        System.out.println("Added edges: 0-1, 0-2, 1-3, 2-4, 3-4");

        listGraph.displayList();

        System.out.println("\n-- hasEdge --");
        System.out.println("hasEdge(0, 1): " + listGraph.hasEdge(0, 1));
        System.out.println("hasEdge(0, 3): " + listGraph.hasEdge(0, 3));

        System.out.println("\n-- getNeighbors --");
        listGraph.getNeighbors(0);
        listGraph.getNeighbors(3);

        System.out.println("\n-- getDegree --");
        System.out.println("Degree of vertex 0: " + listGraph.getDegree(0));
        System.out.println("Degree of vertex 3: " + listGraph.getDegree(3));

        System.out.println("\n-- removeEdge --");
        System.out.println("Removing edge 0-1");
        listGraph.removeEdge(0, 1);
        System.out.println("hasEdge(0, 1) after removal: " + listGraph.hasEdge(0, 1));
        listGraph.getNeighbors(0);
        listGraph.displayList();

        // --- Adjacency List Graph (directed) ---
        System.out.println("\n=== Adjacency List Graph Directed ===");
        AdjacencyListGraph directedListGraph = new AdjacencyListGraph(4, true);

        directedListGraph.addEdge(0, 1);
        directedListGraph.addEdge(0, 2);
        directedListGraph.addEdge(1, 3);
        directedListGraph.addEdge(2, 3);
        System.out.println("Added edges: 0->1, 0->2, 1->3, 2->3");

        directedListGraph.displayList();

        System.out.println("\n-- hasEdge --");
        System.out.println("hasEdge(0, 1): " + directedListGraph.hasEdge(0, 1));
        System.out.println("hasEdge(1, 0): " + directedListGraph.hasEdge(1, 0));

        System.out.println("\n-- getNeighbors --");
        directedListGraph.getNeighbors(0);
        directedListGraph.getNeighbors(3);

        System.out.println("\n-- getDegree (out-degree) --");
        System.out.println("Degree of vertex 0: " + directedListGraph.getDegree(0));
        System.out.println("Degree of vertex 3: " + directedListGraph.getDegree(3));

        System.out.println("\n-- removeEdge --");
        System.out.println("Removing edge 0->2");
        directedListGraph.removeEdge(0, 2);
        System.out.println("hasEdge(0, 2) after removal: " + directedListGraph.hasEdge(0, 2));
        directedListGraph.getNeighbors(0);
        directedListGraph.displayList();

        // --- Adjacency List Weighted Graph ---
        System.out.println("\n=== Adjacency List Weighted Graph Undirected ===");
        AdjacencyListWeightedGraph weightedGraph = new AdjacencyListWeightedGraph(5, false);

        weightedGraph.addEdge(0, 1);
        weightedGraph.addEdge(0, 2);
        weightedGraph.addWeightedEdge(1, 3, 5);
        weightedGraph.addWeightedEdge(2, 4, 3);
        weightedGraph.addWeightedEdge(3, 4, 7);
        System.out.println("Added edges: 0-1, 0-2, 1-3(w=5), 2-4(w=3), 3-4(w=7)");

        weightedGraph.displayList();

        System.out.println("\n-- hasEdge --");
        System.out.println("hasEdge(0, 1): " + weightedGraph.hasEdge(0, 1));
        System.out.println("hasEdge(0, 3): " + weightedGraph.hasEdge(0, 3));

        System.out.println("\n-- getNeighbors --");
        weightedGraph.getNeighbors(0);
        weightedGraph.getNeighbors(3);

        System.out.println("\n-- getDegree --");
        System.out.println("Degree of vertex 0: " + weightedGraph.getDegree(0));
        System.out.println("Degree of vertex 3: " + weightedGraph.getDegree(3));

        System.out.println("\n-- removeEdge --");
        System.out.println("Removing edge 0-1");
        weightedGraph.removeEdge(0, 1);
        System.out.println("hasEdge(0, 1) after removal: " + weightedGraph.hasEdge(0, 1));
        weightedGraph.getNeighbors(0);
        weightedGraph.displayList();

        // --- HashMap section ---
        System.out.println("\n=== HashMap Practice ===");
        HashMap<String, Integer> mapPractice = new HashMap<>();
        mapPractice.put("Dilshan", 70);
        mapPractice.put("Kamal", 80);
        mapPractice.put("Amal", 60);
        mapPractice.put("Henry", 50);

        System.out.println("\n-- Iterate using keySet --");
        mapPractice.keySet().forEach(key -> System.out.println(key + ": " + mapPractice.get(key)));

        System.out.println("\n-- Iterate using values --");
        mapPractice.values().forEach(value -> System.out.println(value));

        System.out.println("\n-- Iterate using forEach --");
        mapPractice.forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println("\nDilshan's score: " + mapPractice.get("Dilshan"));

        System.out.println("\n-- Number counts --");
        int[] array = {1, 1, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7, 8, 8};

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        countMap.forEach((key, value) -> System.out.println(key + " count = " + value));
    }
}