package 자료구조;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph_Adjacency_Matrix {
    public static int[][] createAdjacencyMatrix(ArrayList<ArrayList<Integer> > graph, int numVertices) {
        // Initialize the adjacency matrix with zeros
        int[][] adjMatrix
                = new int[numVertices][numVertices];

        // Fill the adjacency matrix based on the edges in
        // the graph
        for (int i = 0; i < numVertices; ++i) {
            for (int j = 0; j < numVertices; ++j) {
                if (graph.get(i).get(j) == 1) {
                    adjMatrix[i][j] = 1;
                    adjMatrix[j][i] = 1; // For undirected graph, set
                    // symmetric entries
                }
            }
        }

        return adjMatrix;
    }

    public static void main(String[] args) {
        // The indices represent the vertices, and the
        // values are lists of neighboring vertices
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        graph.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1)));
        graph.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));

        int numVertices = graph.size();

        // Create the adjacency matrix
        int[][] adjMatrix = createAdjacencyMatrix(graph, numVertices);

        // Print the adjacency matrix
        for (int i = 0; i < numVertices; ++i) {
            for (int j = 0; j < numVertices; ++j) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
