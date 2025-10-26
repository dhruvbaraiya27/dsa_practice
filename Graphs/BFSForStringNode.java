package com.example;

import java.util.*;

public class BFSForStringNode {
    public static List<String> bfsOfGraph(int n, int m, List<List<String>> edges) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(List<String> edge: edges) {
            String u = edge.get(0);
            String v = edge.get(1);

//            if(!adjList.containsKey(u)) {
//                adjList.put(u, new ArrayList<>());
//            }
//            if (!adjList.containsKey(v)) {
//                adjList.put(v, new ArrayList<>());
//            }
//            adjList.get(u).add(v);
//            adjList.get(v).add(u);

            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k-> new ArrayList<>()).add(u);

            //if directed graph
//            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // only u -> v
//            adjList.computeIfAbsent(v, k -> new ArrayList<>());
        }

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        for(String start: adjList.keySet()) {
            if(!visited.contains(start)) {
                q.add(start);
                visited.add(start);

                while(!q.isEmpty()) {
                    String node = q.poll();
                    result.add(node);
                    for(String neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                        if(!visited.contains(neighbor)) {
                            q.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return result;
    }
}
