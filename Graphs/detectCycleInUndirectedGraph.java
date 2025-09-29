class Solution {
    
    //using DFS approach
    private static boolean isCycleDetectedDFS(int node, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                boolean isCycle = isCycleDetectedDFS(neighbor, node, adjList, visited);
                if(isCycle) return true;
            }
            else if(neighbor != parent) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                if(isCycleDetectedDFS(i, -1, adjList, visited)) return true;
            }
        }
        return false;
        
    }
}
