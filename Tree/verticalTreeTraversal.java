/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
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
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // add your code here
        if(root == null)    return new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node currNode = temp.node;
            int currIdx = temp.index;
            
            map.putIfAbsent(currIdx, new ArrayList<>());
            map.get(currIdx).add(currNode.data);
            
            if(currNode.left!=null) q.add(new Pair(currNode.left, currIdx-1));
            if(currNode.right!=null)    q.add(new Pair(currNode.right, currIdx+1));
            
        }
        
        for(ArrayList<Integer> list : map.values())
        {
            result.add(list);
        }
        
        return result;
        
    }
}
