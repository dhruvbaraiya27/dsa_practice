import java.util.*;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);

        }

        int[][] result = new int[n][];
        for(int i=0;i<n;i++) {
            List<Integer> neighbors = adjList.get(i);
            Collections.sort(neighbors);
            result[i] = new int[neighbors.size() + 1];
            result[i][0] = i;
            for(int j=0;j<neighbors.size();j++){
                result[i][j+1] = neighbors.get(j);
            } 
        }
        return result;

        
        

    }
}
