class Solution {
    //using DFS
    
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) adjList.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
        }
        
        int[] indegrees = new int[V];
        for(int i=0;i<V;i++) {
            for(int j: adjList.get(i)) {
                indegrees[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        for(int i=0; i<V;i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int front = q.poll();
            cnt++;
            for(int neighbor : adjList.get(front)) {
                indegrees[neighbor]--;
                if(indegrees[neighbor]==0) {
                    q.add(neighbor);
                }
            }
        }
        return cnt!=V;
        
    }
}
