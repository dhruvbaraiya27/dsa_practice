package com.example;
import java.util.*;

public class GenericBFSDFS {
    // Simple generic edge holder
    class Edge<T> {
        final T u, v;
        Edge(T u, T v) { this.u = u; this.v = v; }
    }

    public class GenericGraph {

        /** Build adjacency for generic nodes. Uses LinkedHashMap to preserve insertion order of keys. */
        public static <T> Map<T, List<T>> buildAdjacency(List<Edge<T>> edges, boolean directed) {
            Map<T, List<T>> adj = new LinkedHashMap<>(); // preserves order of first-seen nodes

            for (Edge<T> e : edges) {
                // ensure lists exist
                adj.computeIfAbsent(e.u, k -> new ArrayList<>());
                adj.computeIfAbsent(e.v, k -> new ArrayList<>());

                // add edge u -> v
                adj.get(e.u).add(e.v);

                // if undirected, also add v -> u
                if (!directed) {
                    adj.get(e.v).add(e.u);
                }
            }
            return adj;
        }

        /** BFS over all components, visiting neighbors in the order they appear in adjacency lists. */
        public static <T> List<T> bfsAll(Map<T, List<T>> adj) {
            List<T> order = new ArrayList<>();
            Set<T> visited = new LinkedHashSet<>();
            ArrayDeque<T> q = new ArrayDeque<>();

            for (T start : adj.keySet()) {
                if (visited.contains(start)) continue;

                visited.add(start);
                q.add(start);

                while (!q.isEmpty()) {
                    T u = q.poll();
                    order.add(u);

                    for (T v : adj.getOrDefault(u, Collections.emptyList())) {
                        if (!visited.contains(v)) {
                            visited.add(v);
                            q.add(v);
                        }
                    }
                }
            }
            return order;
        }

        /** DFS (recursive) over all components, neighbor order preserved. */
        public static <T> List<T> dfsAll(Map<T, List<T>> adj) {
            List<T> order = new ArrayList<>();
            Set<T> visited = new LinkedHashSet<>();

            for (T start : adj.keySet()) {
                if (!visited.contains(start)) {
                    dfs(start, adj, visited, order);
                }
            }
            return order;
        }

        private static <T> void dfs(T u, Map<T, List<T>> adj, Set<T> visited, List<T> out) {
            visited.add(u);
            out.add(u);
            for (T v : adj.getOrDefault(u, Collections.emptyList())) {
                if (!visited.contains(v)) {
                    dfs(v, adj, visited, out);
                }
            }
        }

        // --- Example usage with Strings ---
        public static void main(String[] args) {
            // Input edges (labels can be any type, here Strings)
            List<Edge<String>> edges = Arrays.asList(
                    new Edge<>("a", "b"),
                    new Edge<>("b", "c"),
                    new Edge<>("c", "a"),
                    new Edge<>("d", "e")
            );

            // Undirected
            Map<String, List<String>> undirected = buildAdjacency(edges, false);
            System.out.println("BFS (undirected): " + bfsAll(undirected)); // [a, b, c, d, e]
            System.out.println("DFS (undirected): " + dfsAll(undirected)); // [a, b, c, d, e]

            // Directed
            Map<String, List<String>> directed = buildAdjacency(edges, true);
            System.out.println("BFS (directed):   " + bfsAll(directed));
            System.out.println("DFS (directed):   " + dfsAll(directed));
        }
    }
}
