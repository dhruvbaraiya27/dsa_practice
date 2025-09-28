class Solution {
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        
        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
         ArrayList<Integer> result = new ArrayList<>();
         int n = adj.size();
         boolean[] visited = new boolean[n];
         
         dfsHelper(0, adj, visited, result);
         return result;
    }
}
