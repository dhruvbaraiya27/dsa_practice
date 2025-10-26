package com.example;

import java.util.*;

public class DFSForStringNodes {
    public static void dfsHelper(String node, Map<String, List<String>> adjList, List<String> result, Set<String> visited) {
        visited.add(node);
        result.add(node);

        for(String neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
            if(!visited.contains(neighbor)) {
                dfsHelper(neighbor, adjList, result, visited);
            }
        }
    }
    public static List<String> dfsOfGraph(int n, int m, List<List<String>> edges) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(List<String> edge : edges) {
            String u = edge.get(0);
            String v = edge.get(1);

            adjList.computeIfAbsent(u,k-> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
            //if directed graph
//            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // only u -> v
//            adjList.computeIfAbsent(v, k -> new ArrayList<>());
        }

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(String start : adjList.keySet()) {
            if(!visited.contains(start)) {
                dfsHelper(start,adjList, result, visited);
            }
        }
        return result;
    }
}
