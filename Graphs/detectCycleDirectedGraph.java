class Solution {
    //using DFS
    
    private boolean checkCycleDFS(int node, boolean[] visited, boolean[] dfsVisited, List<List<Integer>> adjList) {
        visited[node] = true;
        dfsVisited[node] = true;
        
        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                boolean cycleDetected = checkCycleDFS(neighbor, visited, dfsVisited, adjList);
                if(cycleDetected)   return true;
            }
            else if(dfsVisited[neighbor])   return true;
        }
        dfsVisited[node] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i< edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] dfsVisited = new boolean[V];
        
        for(int i=0; i<V; i++) {
            boolean cycleFound = checkCycleDFS(i, visited, dfsVisited, adjList);
            if(cycleFound)  return true;
        }
        
        return false;
        
    }
}
