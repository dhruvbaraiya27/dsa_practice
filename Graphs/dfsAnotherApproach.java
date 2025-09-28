import java.util.*;

public class Solution {
    private static ArrayList<ArrayList<Integer>> findAdjList(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            int u = edges.get(i).get(0);
            int ver=edges.get(i).get(1);

            adjList.get(u).add(ver);
            adjList.get(ver).add(u);
        }
        for (ArrayList<Integer> list : adjList) {
            Collections.sort(list);
        }
        return adjList;

    }
    private static void dfsHelper(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> component) {
        visited[node]= true;
        component.add(node);

        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                dfsHelper(neighbor,adjList, visited, component);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjList = findAdjList(v,e,edges);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfsHelper(i, adjList, visited, component);
                result.add(component);
            }
        }
        return result;

    }
}
