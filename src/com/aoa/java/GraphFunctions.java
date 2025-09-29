package com.aoa.java;
import java.util.*;

public class GraphFunctions {
    public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, List<ArrayList<Integer>> graph) {
        if (recStack[v]) return true;
        if (visited[v]) return false;

        visited[v] = true;
        recStack[v] = true;
        
        for (Integer neighbor : graph.get(v)) {
            if (isCyclicUtil(neighbor, visited, recStack, graph)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    public boolean Dijkstra(List<ArrayList<Integer>> graph, int start, int end) {
        int numNodes = graph.size();
        int[] dist = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Integer neighbor : graph.get(currentNode)) {
                int newDist = currentDist + 1; // Assuming all edges have weight 1
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }

        return dist[end] != Integer.MAX_VALUE;
    }

    public List<Integer> connectedComponents(List<ArrayList<Integer>> graph) {
        int numNodes = graph.size();
        boolean[] visited = new boolean[numNodes];
        List<Integer> componentSizes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                int size = dfs(i, visited, graph);
                componentSizes.add(size);
            }
        }

        return componentSizes;
    }

    // Helper method to perform DFS and return the size of the connected component
    private int dfs(int node, boolean[] visited, List<ArrayList<Integer>> graph) {
        visited[node] = true;
        int size = 1;
        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, visited, graph);
            }
        }
        return size;
    }
}