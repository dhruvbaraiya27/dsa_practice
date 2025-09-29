class Solution {
    
    //using BFS(Kahn's Algo)
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++)  adjList.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList.get(u).add(v);
        }
        
        int[] indegrees = new int[V];
        for(int i=0; i<V; i++) {
            for(int j: adjList.get(i)) {
                indegrees[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indegrees[i]==0) {
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);
            for(int neighbor: adjList.get(front)) {
                indegrees[neighbor]--;
                if(indegrees[neighbor]==0)  q.add(neighbor);
            }
        }
        return ans;
    }
}
