class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for(int start=0; start < n; start++){
            if(!visited[start]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                visited[start] = true;
                
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    result.add(node);
                    
                    for(int neighbor : adj.get(node)){
                        if(!visited[neighbor]){
                            queue.add(neighbor);
                            visited[neighbor]= true;
                        }
                    }
                }
            }
        }
        return result;
        
    }
}
