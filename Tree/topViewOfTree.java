/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    
    private static class Pair{
        Node node;
        int index;
        
        Pair(Node node, int index)
        {
            this.node = node;
            this.index = index;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        if(root==null)  return null;
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node currNode = temp.node;
            int currIdx = temp.index;
            
            if(!map.containsKey(currIdx))
            {
                map.put(currIdx, currNode.data);
            }
            
            if(currNode.left!=null) q.add(new Pair(currNode.left, currIdx-1));
            if(currNode.right!=null)    q.add(new Pair(currNode.right, currIdx+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }
        
        return result;
        
    }
}
