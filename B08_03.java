package Hw9;

//TASK B08_03

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class UndirectedGraph {
    private Map<String, Set<String>> adjacencyList;

    public UndirectedGraph() {adjacencyList = new HashMap<>();}

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void removeVertex(String vertex) {
        Set<String> edges = adjacencyList.get(vertex);
        if (edges != null) {
            for (String neighbor: edges) {
                adjacencyList.get(neighbor).remove(vertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    public void addEdge(String firstVertex, String secondVertex) {
        addVertex(firstVertex);
        addVertex(secondVertex);
        adjacencyList.get(firstVertex).add(secondVertex);
        adjacencyList.get(secondVertex).add(firstVertex);
    }

    public void removeEdge(String firstVertex, String secondVertex) {
        Set<String> edges1 = adjacencyList.get(firstVertex);
        Set<String> edges2 = adjacencyList.get(secondVertex);
        if (edges1 != null) edges1.remove(secondVertex);
        if (edges2 != null) edges2.remove(firstVertex);
    }

    public void printGraph() {
        for (Map.Entry<String, Set<String>> entry: adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (String neighbor: entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "D");

        System.out.println("Graph:");
        graph.printGraph();

        graph.removeVertex("D");
        System.out.println("\nGraph after removing vertex D:");
        graph.printGraph();

        graph.removeEdge("B", "C");
        System.out.println("\nGraph after removing edge B-C:");
        graph.printGraph();
    }
}
