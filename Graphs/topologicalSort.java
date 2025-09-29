class Solution {
    private static void topological(int node, boolean[] visited, Stack<Integer> s, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;
        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                topological(neighbor, visited, s, adjList);
            }
        }
        s.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i< edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                topological(i, visited, s, adjList);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!s.isEmpty()) {
            result.add(s.pop());
        }
        return result;
    }
}
