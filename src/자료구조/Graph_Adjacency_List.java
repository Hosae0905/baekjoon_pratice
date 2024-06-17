package 자료구조;

import java.util.ArrayList;
import java.util.List;

public class Graph_Adjacency_List {
    public static List<List<Integer>>
    createAdjacencyList(List<List<Integer> > edges,
                        int numVertices)
    {
        // Initialize the adjacency list
        List<List<Integer> > adjList
                = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list based on the edges in the
        // graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            // Since the graph is undirected, therefore we
            // push the edges in both the directions
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

    public static void main(String[] args)
    {
        // Undirected Graph of 4 nodes
        int numVertices = 4;
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(1, 2));
        edges.add(List.of(2, 3));
        edges.add(List.of(3, 1));

        // Create the adjacency list
        List<List<Integer> > adjList
                = createAdjacencyList(edges, numVertices);

        // Print the adjacency list
        for (int i = 0; i < numVertices; ++i) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size();
                 ++j) {
                System.out.print(adjList.get(i).get(j)
                        + " ");
            }
            System.out.println();
        }
    }
}
