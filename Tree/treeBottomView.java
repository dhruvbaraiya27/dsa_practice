/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    
    static class Pair{
        Node node;
        int index;
        
        Pair(Node node, int index)
        {
            this.node = node;
            this.index = index;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        if(root==null)  return new ArrayList<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node currNode = temp.node;
            int currIdx = temp.index;
            
            map.put(currIdx, currNode.data);
            
            if(currNode.left!=null)  q.add(new Pair(currNode.left, currIdx-1));
            if(currNode.right!=null)    q.add(new Pair(currNode.right, currIdx+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
        
    }
}
