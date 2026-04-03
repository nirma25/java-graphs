package Graph;

public class AdjacencyMatrixGraph {
    int[][] matrix;
    int vertices;
    boolean isDirected;

    public AdjacencyMatrixGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        this.matrix = new int[vertices][vertices];
        System.out.println("Created " + (isDirected ? "directed" : "undirected") + " graph with " + vertices + " vertices");
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        if (!isDirected) {
            matrix[destination][source] = 1;
        }
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        if (!isDirected) {
            matrix[destination][source] = weight;
        }
    }

    public boolean hasEdge(int source, int destination) {
        return matrix[source][destination] != 0;
    }

    public void getNeighbors(int vertex) {
        System.out.print("Neighbors of vertex " + vertex + ": ");
        boolean hasNeighbor = false;
        for (int i = 0; i < vertices; i++) {
            if (matrix[vertex][i] != 0) {
                System.out.print(i + " ");
                hasNeighbor = true;
            }
        }
        if (!hasNeighbor) System.out.print("none");
        System.out.println();
    }

    public void removeEdge(int source, int destination) {
        matrix[source][destination] = 0;
        if (!isDirected) {
            matrix[destination][source] = 0;
        }
    }

    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("  ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}